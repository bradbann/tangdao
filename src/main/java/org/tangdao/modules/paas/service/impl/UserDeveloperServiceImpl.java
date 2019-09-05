package org.tangdao.modules.paas.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.DigestUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.paas.config.PaasRedisConstant;
import org.tangdao.modules.paas.mapper.UserDeveloperMapper;
import org.tangdao.modules.paas.model.domain.UserDeveloper;
import org.tangdao.modules.paas.service.IUserDeveloperService;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDeveloperServiceImpl extends CrudServiceImpl<UserDeveloperMapper, UserDeveloper> implements IUserDeveloperService {
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;

	private String getKey(String appkey) {
        return String.format("%s:%s", PaasRedisConstant.RED_DEVELOPER_LIST, appkey);
    }
	
	@Override
	public UserDeveloper getByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return this.getOne(Wrappers.<UserDeveloper>lambdaQuery().eq(UserDeveloper::getUserCode, userCode));
	}

	@Override
	public UserDeveloper getByAppkey(String appkey) {
		// TODO Auto-generated method stub
		try {
            Object d = stringRedisTemplate.opsForValue().get(getKey(appkey));
            if (d != null) {
                return JSON.parseObject(d.toString(), UserDeveloper.class);
            }
        } catch (Exception e) {
            log.error("REDIS获取开发者数据失败, appkey: {}", appkey, e);
        }
		return this.getOne(Wrappers.<UserDeveloper>lambdaQuery().eq(UserDeveloper::getAppKey, appkey));
	}

	@Override
	public UserDeveloper getByAppkey(String appkey, String appSecret) {
		// TODO Auto-generated method stub
		if (StringUtils.isEmpty(appkey) || StringUtils.isEmpty(appSecret)) {
            return null;
        }
		return this.getOne(Wrappers.<UserDeveloper>lambdaQuery().eq(UserDeveloper::getAppKey, appkey).eq(UserDeveloper::getAppSecret, appSecret));
	}
	
	/**
     * TODO 生成密钥密码
     * 
     * @return
     */
    private byte[] genSalt() {
        return DigestUtils.genSalt(12);
    }

	@Override
	public UserDeveloper saveWithReturn(String userCode) {
		UserDeveloper developer = new UserDeveloper();
        developer.setUserCode(userCode);
        developer.setAppKey(IdWorker.getIdStr());
        developer.setSalt(genSalt().toString());
        developer.setAppSecret(DigestUtils.digest("".getBytes(), "SHA-1", developer.getSalt().getBytes(), 1).toString());
        if (this.save(developer)) {
            pushToRedis(developer);
            return developer;
        }
        return null;
	}

	@Override
	public boolean reloadToRedis() {
		List<UserDeveloper> list = this.select();
        if (CollectionUtils.isEmpty(list)) {
            log.warn("可用开发者数据为空");
            return false;
        }

        List<Object> con = stringRedisTemplate.execute((connection) -> {
            RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
            connection.openPipeline();
            for (UserDeveloper developer : list) {
                byte[] key = serializer.serialize(getKey(developer.getAppKey()));
                connection.set(key, serializer.serialize(JSON.toJSONString(developer)));
            }

            return connection.closePipeline();

        }, false, true);

        return CollectionUtils.isNotEmpty(con);
    }
	
	private boolean pushToRedis(UserDeveloper developer) {
        try {
            stringRedisTemplate.opsForValue().set(getKey(developer.getAppKey()), JSON.toJSONString(developer));
            return true;
        } catch (Exception e) {
            log.warn("REDIS 加载用户映射数据失败", e);
            return false;
        }
	}
	
    public boolean update(UserDeveloper developer) {
        // developer secret not null,update developer secret and salt
        UserDeveloper d = this.get(developer.getId());
        // 2017-02-27 判断加密串是否有变化，如果
        if (StringUtils.isNotEmpty(developer.getAppSecret()) && !developer.getAppSecret().equals(d.getAppSecret())) {
            d.setSalt(developer.getSalt());
            d.setAppSecret(developer.getAppSecret());
        }

        // 判断APPKEY是否发生变化
        if (StringUtils.isNotEmpty(developer.getAppKey()) && !developer.getAppKey().equals(d.getAppKey())) {
            // 如果APPKEY 发生变化，则需要移除原有的缓存，产生新的缓存信息
            removeRedis(d.getAppKey());
            d.setAppKey(developer.getAppKey());
        }
        
        boolean result = this.update(d);
        if (result) {
            pushToRedis(d);
        }

        return result;
    }

	private boolean removeRedis(String appkey) {
        try {
            stringRedisTemplate.delete(getKey(appkey));
            return true;
        } catch (Exception e) {
            log.warn("REDIS 移除用户映射数据失败, appkey : {}", appkey, e);
            return false;
        }
    }


}
