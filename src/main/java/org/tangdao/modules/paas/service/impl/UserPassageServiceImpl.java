package org.tangdao.modules.paas.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.exchanger.config.CommonContext.PlatformType;
import org.tangdao.modules.paas.config.PaasRedisConstant;
import org.tangdao.modules.paas.config.SettingsContext.SysDictType;
import org.tangdao.modules.paas.config.SettingsContext.UserDefaultPassageGroupKey;
import org.tangdao.modules.paas.mapper.UserPassageMapper;
import org.tangdao.modules.paas.model.domain.UserPassage;
import org.tangdao.modules.paas.service.IUserPassageService;
import org.tangdao.modules.sys.utils.DictUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * 用户通道配置ServiceImpl
 * @author ruyang
 * @version 2019-09-06
 */
@Service
public class UserPassageServiceImpl extends CrudServiceImpl<UserPassageMapper, UserPassage> implements IUserPassageService{
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final Logger        logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<UserPassage> findByUserCode(String userCode) {
    	return this.select(Wrappers.<UserPassage>lambdaQuery().eq(UserPassage::getUserCode, userCode));
    }

    private String getKey(String userCode, int type) {
        return String.format("%s:%d:%d", PaasRedisConstant.RED_USER_SMS_PASSAGE, userCode, type);
    }

    @Override
    public String getByUserCodeAndType(String userCode, int type) {
        if (StringUtils.isEmpty(userCode) || type == 0) {
            return null;
        }

        try {
            String passageGroupId = stringRedisTemplate.opsForValue().get(getKey(userCode, type));
            if (StringUtils.isNotBlank(passageGroupId)) return passageGroupId;

        } catch (Exception e) {
            logger.warn("REDIS中查询用户通道信息失败 ：{}", e.getMessage());
        }
        QueryWrapper<UserPassage> queryWrapper = new QueryWrapper<UserPassage>();
        queryWrapper.eq("user_code", userCode);
        queryWrapper.eq("type", type);
        queryWrapper.orderByDesc("id").last(" limit 1");
        UserPassage userPassage =  this.getOne(queryWrapper);
        if (userPassage == null) {
            return null;
        }

        return userPassage.getPassageGroupId();
    }

    @Override
    public List<UserPassage> getPassageGroupListByGroupId(String passageGroupId) {
    	return this.select(Wrappers.<UserPassage>lambdaQuery().eq(UserPassage::getPassageGroupId, passageGroupId));
    }

    @Override
    public boolean save(String userCode, UserPassage userPassage) {
        try {
            userPassage.setUserCode(userCode);
            userPassage.setCreateTime(new Date());
            return super.save(userPassage);
        } catch (Exception e) {
            logger.error("添加用户通道错误，{}", e);
            return false;
        }
    }

    /**
     * TODO 保存用户通道组配置
     * 
     * @param passageGroupId 通道组ID
     * @param userId 用户ID
     * @param type 平台类型：短信/语音/...
     */
    private void save(String passageGroupId, String userCode, Integer type) {
        try {
            if (passageGroupId == null || userCode == null || type == null) {
                logger.error("插入用户通道失败，passageGroupId: {}, userCode:{}, type: {}", passageGroupId, userCode, type);
                return;
            }
            UserPassage userPassage = new UserPassage();
            userPassage.setPassageGroupId(passageGroupId);
            userPassage.setType(type);
            userPassage.setUserCode(userCode);
            userPassage.setCreateTime(new Date());

            boolean effect = super.save(userPassage);
            if (effect) {
                pushToRedis(userPassage);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean initUserPassage(String userCode, List<UserPassage> passageList) {
        try {
            if (ListUtils.isEmpty(passageList)) {
                // 如果传递的用户通道集合为空，则根据系统参数配置查询平台所有业务的默认可用通道信息，插入值用户通道关系表中
//                List<SystemConfig> systemConfigs = systemConfigService.findByType(SystemConfigType.USER_DEFAULT_PASSAGE_GROUP.name());
            	List<JSONObject> dictTypes = DictUtils.getDictList(SysDictType.USER_DEFAULT_PASSAGE_GROUP.name());
                if (ListUtils.isEmpty(dictTypes)) {
                    throw new RuntimeException("没有可用默认通道组，请配置");
                }

                Integer type = null;
                for (JSONObject map : dictTypes) {
                    if (UserDefaultPassageGroupKey.SMS_DEFAULT_PASSAGE_GROUP.name().equalsIgnoreCase(ObjectUtils.toString2(map.get("dictLabel")))) {
                        type = PlatformType.SEND_MESSAGE_SERVICE.getCode();
                    } else if (UserDefaultPassageGroupKey.FS_DEFAULT_PASSAGE_GROUP.name().equalsIgnoreCase(ObjectUtils.toString2(map.get("dictLabel")))) {
                        type = PlatformType.FLUX_SERVICE.getCode();
                    } else if (UserDefaultPassageGroupKey.VS_DEFAULT_PASSAGE_GROUP.name().equalsIgnoreCase(ObjectUtils.toString2(map.get("dictLabel")))) {
                        type = PlatformType.VOICE_SERVICE.getCode();
                    }

                    save(ObjectUtils.toString2(map.get("dictValue")), userCode, type);
                }
                return true;
            }

            List<Integer> busiCodes = PlatformType.allCodes();
            // 如果传递的通道和不为空，则遍历传递的通道信息，并对平台所有业务代码进行 差值比较
            for (UserPassage passage : passageList) {
                save(passage.getPassageGroupId(), userCode, passage.getType());
                busiCodes.remove(passage.getType());
            }

            // busiCodes 为空则表明，传递的通道集合包含平台所有业务的通道信息，无需补齐
            if (ListUtils.isEmpty(busiCodes)) {
                return true;
            }

            // 如果此值不为空，则表明该业务没有设置通道，需要查询是否存在默认通道
            for (Integer code : busiCodes) {
                String key = UserDefaultPassageGroupKey.key(code);
                if (StringUtils.isEmpty(key)) {
                    continue;
                }
                
                String passageGroupId = DictUtils.getDictValue(SysDictType.USER_DEFAULT_PASSAGE_GROUP.name(), key, null);
//                SystemConfig config = systemConfigService.findByTypeAndKey(SysDictType.USER_DEFAULT_PASSAGE_GROUP.name(), key);
                if (passageGroupId == null) {
                    logger.warn("没有可用默认通道组，请配置");
                    continue;
                }

                save(passageGroupId, userCode, code);
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = RuntimeException.class)
    public boolean save(String userCode, List<UserPassage> userPassages) {
        if (ListUtils.isEmpty(userPassages)) {
            return false;
        }

        try {
            for (UserPassage userPassage : userPassages) {
                save(userCode, userPassage);
                pushToRedis(userPassage);
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(String userCode, int type, String passageGroupId) {
    	
        int effect = this.getBaseMapper().updateByUserCodeAndType(passageGroupId, userCode,
                                                             PlatformType.SEND_MESSAGE_SERVICE.getCode());
        if (effect > 0) {
            pushToRedis(new UserPassage(userCode, type, passageGroupId));
        }

        return true;
    }

    private boolean pushToRedis(UserPassage userPassage) {
        try {
            stringRedisTemplate.opsForValue().set(getKey(userPassage.getUserCode(), userPassage.getType()),
                                                  userPassage.getPassageGroupId() + "");
            return true;
        } catch (Exception e) {
            logger.warn("REDIS 加载用户通道组配置数据失败", e);
            return false;
        }
    }

    @Override
    public boolean reloadModelToRedis() {
        List<UserPassage> list = super.select();
        if (ListUtils.isEmpty(list)) {
            logger.warn("可用用户通道组数据为空");
            return false;
        }

        stringRedisTemplate.execute((connection) -> {

            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            connection.openPipeline();
            for (UserPassage userPassage : list) {
                byte[] key = serializer.serialize(getKey(userPassage.getUserCode(), userPassage.getType()));

                connection.set(key, serializer.serialize(JSON.toJSONString(userPassage)));
            }

            return connection.closePipeline();

        }, false, true);

        return true;
    }
}