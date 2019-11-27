package org.tangdao.modules.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.tangdao.common.serializer.SerializationUtils;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.modules.sys.config.SysRedisConstant;
import org.tangdao.modules.sys.mapper.ConfigMapper;
import org.tangdao.modules.sys.model.domain.Config;
import org.tangdao.modules.sys.model.domain.DictData;
import org.tangdao.modules.sys.service.IConfigService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class ConfigServiceImpl extends CrudServiceImpl<ConfigMapper, Config> implements IConfigService {

	@Resource
    private StringRedisTemplate                  stringRedisTemplate;
	
	private final Logger                         logger                          = LoggerFactory.getLogger(getClass());
	
    public Config getConfigByKey(String configKey) {
    	try {
    		Object obj = stringRedisTemplate.opsForHash().get(SysRedisConstant.RED_SYS_CONFIG_LIST, configKey);
    		if(obj != null) {
    			return (Config) obj;
    		}
		} catch (Exception e) {
			 logger.warn("REDIS 加载失败，将于DB加载", e);
		}
    	Config config = super.getOne(Wrappers.<Config>lambdaQuery().eq(Config::getConfigKey, configKey));
    	if(config != null) {
    		loadToRedis(config);
    	}
    	return config;
    }
	
	@Override
    public boolean reloadToRedis() {
		List<Config> list = super.select(Wrappers.<Config>lambdaQuery().eq(Config::getStatus, DictData.STATUS_NORMAL));
	    if (ListUtils.isEmpty(list)) {
	        logger.warn("缓冲系统配置失败，系统配置可用数据为空，请排查");
            return false;
	    }
	
	    try {
	    	stringRedisTemplate.delete(SysRedisConstant.RED_SYS_CONFIG_LIST + "*");
            List<Object> con = stringRedisTemplate.execute((connection) -> {
                RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
                connection.openPipeline();
                for (Config config : list) {
                    byte[] mainKey = serializer.serialize(SysRedisConstant.RED_SYS_CONFIG_LIST);
                    byte[] assistKey = serializer.serialize(config.getConfigKey());
                    connection.hSet(mainKey, assistKey, SerializationUtils.serializeWithoutException(config));
                }

                return connection.closePipeline();

            }, false, true);

            return ListUtils.isNotEmpty(con);
        } catch (Exception e) {
            logger.warn("REDIS 重载数据失败", e);
            return false;
        }
    }
	
	/**
     * 加载到REDIS
     * 
     * @param config 可用配置
     */
    private void loadToRedis(Config config) {
        try {
            stringRedisTemplate.execute((connection) -> {
                RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
                byte[] mainKey = serializer.serialize(SysRedisConstant.RED_SYS_CONFIG_LIST);
                byte[] assistKey = serializer.serialize(config.getConfigKey());

                connection.openPipeline();
				connection.hSet(mainKey, assistKey, SerializationUtils.serializeWithoutException(config));

                return connection.closePipeline();
            }, false, true);

        } catch (Exception e) {
            logger.warn("Redis 加载失败", e);
        }
    }
	
}
