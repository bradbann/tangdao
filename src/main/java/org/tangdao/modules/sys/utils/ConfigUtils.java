package org.tangdao.modules.sys.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.tangdao.common.config.Contents;
import org.tangdao.common.config.Global;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.Config;
import org.tangdao.modules.sys.service.IConfigService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @ClassName: ConfigUtils.java
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ruyang
 * @date 2019年3月5日 下午3:52:39
 * 
 */
public class ConfigUtils {
	
	private static final class Static {
		private static IConfigService configService = SpringUtils.getBean(IConfigService.class);
		private static RedisTemplate<String, Object> redis = SpringUtils.getBean("redisTemplate");
	}

	public static void clearCache() {
		Static.redis.expire(Contents.configMap, 0L, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unchecked")
	public static synchronized Config getConfig(String key) {
		Map<String, Config> cacheMap = (Map<String, Config>) Static.redis.opsForValue().get(Contents.configMap);
		
		if (cacheMap == null) {
			cacheMap = MapUtils.newHashMap();
			QueryWrapper<Config> queryWrapper = new QueryWrapper<Config>();
			queryWrapper.eq("status", Config.STATUS_NORMAL);
			List<Config> list = Static.configService.select(queryWrapper);
			for (Config item : list) {
				cacheMap.put(item.getConfigKey(), item);
			}
			Static.redis.opsForValue().set(Contents.configMap, cacheMap);
		}
		Config config;
		if ((config = (Config) cacheMap.get(key)) == null) {
			config = new Config();
		}
		return config;
	}
	
	public static synchronized String getConfig2(String key, String defValue) {
		String value = Global.getConfig(key);
		if(StringUtils.isBlank(value)) {
			Config config = getConfig(key);
			if(config!=null) {
				return config.getConfigValue();
			}else {
				return defValue;
			}
		}
		return value;
	}
}
