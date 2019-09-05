package org.tangdao.modules.paas.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.paas.config.PaasRedisConstant;
import org.tangdao.modules.paas.mapper.UserSmsConfigMapper;
import org.tangdao.modules.paas.model.domain.UserSmsConfig;
import org.tangdao.modules.paas.service.IUserSmsConfigService;
import org.tangdao.modules.sms.config.UserBalanceConstant;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户短信配置ServiceImpl
 * @author ruyang
 * @version 2019-09-05
 */
@Slf4j
@Service
public class UserSmsConfigServiceImpl extends CrudServiceImpl<UserSmsConfigMapper, UserSmsConfig> implements IUserSmsConfigService{
	
	@Resource
    private StringRedisTemplate  stringRedisTemplate;
	
	private static String getKey(String userCode) {
        return PaasRedisConstant.RED_USER_SMS_CONFIG + ":" + userCode;
    }
	
	@Override
    public UserSmsConfig getByUserCode(String userCode) {
        if(StringUtils.isEmpty(userCode)) {
        	return null;
        }

        try {
            String text = stringRedisTemplate.opsForValue().get(getKey(userCode));
            if (StringUtils.isNotEmpty(text)) {
                return JSON.parseObject(text, UserSmsConfig.class);
            }

        } catch (Exception e) {
            log.warn("REDIS获取用户短信配置失败", e);
        }

        return this.getOne(Wrappers.<UserSmsConfig>lambdaQuery().eq(UserSmsConfig::getUserCode, userCode));
    }
	
	@Override
	public int getSingleChars(String userCode) {
		int wordsPerNum = UserBalanceConstant.WORDS_SIZE_PER_NUM;
        try {
            UserSmsConfig userSmsConfig = getByUserCode(userCode);
            if (userSmsConfig != null) {
                wordsPerNum = userSmsConfig.getSmsWords();
            }

        } catch (Exception e) {
            log.warn("查询用户：{} 短信字数配置失败，将以默认每条字数：{}计费", userCode, wordsPerNum, e);
        }
        return wordsPerNum;
	}

	@Override
	public boolean save(String userCode, int words, String extNumber) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean update(UserSmsConfig config) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	/**
//     * TODO 添加至REDIS
//     * 
//     * @param userSmsConfig
//     */
//    private void pushToRedis(UserSmsConfig userSmsConfig) {
//        try {
//            stringRedisTemplate.opsForValue().set(getKey(userSmsConfig.getUserCode()), JSON.toJSONString(userSmsConfig));
//        } catch (Exception e) {
//            log.warn("REDIS 操作用户短信配置失败", e);
//        }
//    }
//
//    private void removeFromRedis(String userCode) {
//        try {
//            stringRedisTemplate.delete(getKey(userCode));
//
//        } catch (Exception e) {
//            log.warn("REDIS 移除用户彩信配置失败", e);
//        }
//    }

	@Override
	public boolean reloadToRedis() {
		List<UserSmsConfig> list = this.select();
        if (CollectionUtils.isEmpty(list)) {
            log.error("用户短信配置数据为空");
            return true;
        }

        List<Object> con = stringRedisTemplate.execute((connection) -> {

            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            connection.openPipeline();
            for (UserSmsConfig config : list) {
                byte[] key = serializer.serialize(getKey(config.getUserCode()));
                connection.set(key, serializer.serialize(JSON.toJSONString(config)));
            }

            return connection.closePipeline();

        }, false, true);

        return CollectionUtils.isNotEmpty(con);
	}
		
}