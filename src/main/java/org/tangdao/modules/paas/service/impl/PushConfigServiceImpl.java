package org.tangdao.modules.paas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.modules.paas.config.PaasRedisConstant;
import org.tangdao.modules.paas.config.SettingsContext.PushConfigStatus;
import org.tangdao.modules.paas.mapper.PushConfigMapper;
import org.tangdao.modules.paas.model.domain.PushConfig;
import org.tangdao.modules.paas.service.IPushConfigService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 推送配置信息表ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class PushConfigServiceImpl extends CrudServiceImpl<PushConfigMapper, PushConfig> implements IPushConfigService{
	@Autowired
    private PushConfigMapper    pushConfigMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    private Logger              logger = LoggerFactory.getLogger(getClass());

    private String getAssistKey(String userCode, int type) {
        return String.format("%s:%s:%d", PaasRedisConstant.RED_USER_PUSH_CONFIG, userCode, type);
    }

    @Override
    public boolean update(PushConfig record) {
        if (record.getId() == null) {
            return false;
        }

        record.preUpdate();
        pushToRedis(record.getUserCode(), record.getType(), record);

        return pushConfigMapper.updateById(record) > 0;
    }

    @Override
    public List<PushConfig> findByUserCode(String userCode) {
    	return this.select(Wrappers.<PushConfig>lambdaQuery().eq(PushConfig::getUserCode, userCode));
    }

    @Override
    public boolean save(PushConfig record) {
    	record.preInsert();
        int id = pushConfigMapper.insert(record);
        PushConfig c = selectByUserCodeAndType(record.getUserCode(), record.getType());
        record.setId(c.getId());
        pushToRedis(record.getUserCode(), record.getType(), record);
        return id > 0;
    }

    @Override
    public PushConfig getByUserCode(String userCode, int type) {
        try {
            Object object = stringRedisTemplate.opsForValue().get(getAssistKey(userCode, type));
            if (object != null) {
                return JSON.parseObject(object.toString(), PushConfig.class);
            }

        } catch (Exception e) {
            logger.warn("REDIS 查询推送配置失败", e);
        }
        return selectByUserCodeAndType(userCode, type);
    }

    @Override
    public PushConfig getPushUrl(String userCode, int callbackUrlType, String customUrl) {
        PushConfig config = getByUserCode(userCode, callbackUrlType);
        if (config == null) {
            return null;
        }

        if (ObjectUtils.toInteger(config.getStatus()) == PushConfigStatus.YES_WITH_POST.getCode()) {
            config.setUrl(customUrl);
        }

        return config;
    }

    /**
     * TODO 添加到REDIS
     * 
     * @param userCode
     * @param type
     * @param pc
     */
    private void pushToRedis(String userCode, int type, PushConfig pc) {
        try {
            stringRedisTemplate.opsForValue().set(getAssistKey(userCode, type), JSON.toJSONString(pc));
        } catch (Exception e) {
            logger.warn("REDIS 推送配置操作失败", e);
        }
    }

    @Override
    public boolean reloadToRedis() {
        List<PushConfig> list = this.select();
        if (ListUtils.isEmpty(list)) {
            logger.warn("用户推送设置数据查询为空");
            return false;
        }

        List<Object> con = stringRedisTemplate.execute((connection) -> {

            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            connection.openPipeline();
            for (PushConfig config : list) {
                byte[] key = serializer.serialize(getAssistKey(config.getUserCode(), config.getType()));
                connection.set(key, serializer.serialize(JSON.toJSONString(config)));
            }

            return connection.closePipeline();

        }, false, true);

        return ListUtils.isNotEmpty(con);
    }

    @Override
    public int updateByUserCode(PushConfig pushConFig) {
        int result = 0;
        try {
            // 判断如果用户推送记录中没有数据，则插入推送信息
            PushConfig pushConfig = selectByUserCodeAndType(pushConFig.getUserCode(), pushConFig.getType());
            if (pushConfig == null) {
                pushConFig.preInsert();
                result = pushConfigMapper.insert(pushConFig);
            }
            result = pushConfigMapper.updateByUserCode(pushConFig);

            // 查询修改后数据存储到缓存中
            PushConfig cf = selectByUserCodeAndType(pushConFig.getUserCode(), pushConFig.getType());
            if (cf == null) {
                {
                    return 0;
                }
            }

            pushToRedis(cf.getUserCode(), cf.getType(), cf);
        } catch (Exception e) {
            logger.error("更新用户推送信息失败：{}", JSON.toJSONString(pushConFig), e);
        }

        return result;
    }
    
    public PushConfig selectByUserCodeAndType(String userCode, int type) {
    	QueryWrapper<PushConfig> queryWrapper = new QueryWrapper<PushConfig>();
    	queryWrapper.eq("user_code", userCode);
    	queryWrapper.eq("type", type);
    	queryWrapper.orderByDesc("id");
    	queryWrapper.last("limit 1");
    	return this.getOne(queryWrapper);
    }
}