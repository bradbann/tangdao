package org.tangdao.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.tangdao.common.serializer.SerializationUtils;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.modules.sys.config.SysRedisConstant;
import org.tangdao.modules.sys.mapper.DictDataMapper;
import org.tangdao.modules.sys.model.domain.DictData;
import org.tangdao.modules.sys.service.IDictDataService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class DictDataServiceImpl extends CrudServiceImpl<DictDataMapper, DictData> implements IDictDataService {
	
	@Resource
    private StringRedisTemplate                  stringRedisTemplate;
	
	private final Logger                         logger                          = LoggerFactory.getLogger(getClass());
	
	@SuppressWarnings("unchecked")
	public Map<String, List<DictData>> getDictDataList() {
		
		Map<String, List<DictData>> dictDataMap = MapUtils.newHashMap();
    	try {
    		Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(SysRedisConstant.RED_SYS_DICT_DATA_LIST);
    		if (MapUtils.isNotEmpty(entries)) {
                for (Object key : entries.keySet()) {
                	List<DictData> list = (List<DictData>) entries.get(key);
                	dictDataMap.put(key.toString(),  list);
                }
            }else {
            	logger.warn("REDIS DB重新加载...");
            	reloadToRedis();
            }
    		
    		
		} catch (Exception e) {
			 logger.warn("REDIS 加载失败，将于DB加载", e);
		}
		
    	return dictDataMap;
    }
	
	@Override
    public boolean reloadToRedis() {
		List<DictData> list = super.select(Wrappers.<DictData>lambdaQuery().eq(DictData::getStatus, DictData.STATUS_NORMAL).orderByAsc(DictData::getDictSort));
	    if (ListUtils.isEmpty(list)) {
	        logger.warn("缓冲失败，可用数据为空，请排查");
            return false;
	    }
	
	    try {
	    	stringRedisTemplate.delete(SysRedisConstant.RED_SYS_DICT_DATA_LIST + "*");
            List<Object> con = stringRedisTemplate.execute((connection) -> {
                RedisSerializer<String> serializer = stringRedisTemplate.getStringSerializer();
                connection.openPipeline();
                byte[] mainKey = serializer.serialize(SysRedisConstant.RED_SYS_DICT_DATA_LIST);
                
                Map<String, List<DictData>> dictDataMap = MapUtils.newLinkedHashMap();
                List<DictData> targetList = null;
                for (DictData dd : list) {
    				String dictType = dd.getDictType();
    				if (dictDataMap.get(dictType) == null) {
    					targetList = ListUtils.newLinkedList();
    				} else {
    					targetList = dictDataMap.get(dictType);
    				}
    				targetList.add(dd);
    				dictDataMap.put(dictType, targetList);
    			}
                dictDataMap.keySet().stream().forEach(key->{
                	connection.hSet(mainKey, serializer.serialize(key), SerializationUtils.serializeWithoutException(dictDataMap.get(key)));
                });
                return connection.closePipeline();

            }, false, true);

            return ListUtils.isNotEmpty(con);
        } catch (Exception e) {
            logger.warn("REDIS 重载数据失败", e);
            return false;
        }
	}
}
