package org.tangdao.modules.sys.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.tangdao.common.config.Contents;
import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.DictData;
import org.tangdao.modules.sys.service.IDictDataService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.JsonProcessingException;

public class DictUtils {

	private static final class Static {
		private static IDictDataService dictDataService = SpringUtils.getBean(IDictDataService.class);
		private static RedisTemplate<String, Object> redis = SpringUtils.getBean("redisTemplate");
	}

	public static String getDictLabels(String dictType, String dictValues, String defaultValue) {
		if (StringUtils.isNotBlank(dictType) && StringUtils.isNotBlank(dictValues)) {
			List<String> targetList = ListUtils.newArrayList();
			String[] arr = dictValues.split(",");
			for (String str : arr) {
				if (StringUtils.isNotBlank(str)) {
					targetList.add(getDictLabel(dictType, str, defaultValue));
				}
			}
			return StringUtils.join(targetList, ",");
		}
		return defaultValue;
	}

	public static String getDictValues(String dictType, String dictLabels, String defaultValue) {
		if (StringUtils.isNotBlank(dictType) && StringUtils.isNotBlank(dictLabels)) {
			List<String> targetList = ListUtils.newArrayList();
			String[] arr = dictLabels.split(",");
			for (String str : arr) {
				if (StringUtils.isNotBlank(str)) {
					targetList.add(getDictValue(dictType, str, defaultValue));
				}
			}
			return StringUtils.join(targetList, ",");
		}
		return defaultValue;
	}

	public static String getDictLabel(String dictType, String dictValue, String defaultValue) {
		if (StringUtils.isNotBlank(dictType) && StringUtils.isNotBlank(dictValue)) {
			List<Map<String, Object>> list = getDictList(dictType);
			if (list != null) {
				for (Map<String, Object> map : list) {
					if (map.containsValue(dictValue)) {
						return String.valueOf(map.get("dictLabel"));
					}
				}
			}
		}
		return defaultValue;
	}

	public static String getDictValue(String dictType, String dictLabel, String defaultValue) {
		if (StringUtils.isNotBlank(dictType) && StringUtils.isNotBlank(dictLabel)) {
			List<Map<String, Object>> list = getDictList(dictType);
			if (list != null) {
				for (Map<String, Object> map : list) {
					if (map.containsKey(dictLabel)) {
						return String.valueOf(map.get("dictValue"));
					}
				}
			}
		}
		return defaultValue;
	}

	public static List<Map<String, Object>> getDictList(String dictType) {
		Map<String, List<Map<String, Object>>> dictDataMap = getDictList(new DictData(), false);
		if (dictDataMap != null && dictDataMap.size() != 0) {
			List<Map<String, Object>> list = dictDataMap.get(dictType);
			if (list != null) {
				return list;
			}
		}
		return null;
	}

	public static String getDictListJson(String dictType) {
		
		try {
			return JsonMapper.getInstance().writerWithView(DictData.SimpleView.class)
					.writeValueAsString(getDictList(dictType));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "[]";
		}
	}

	/**
	 * 获取字典
	 * 
	 * @param dictData
	 * @param reload
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, List<Map<String, Object>>> getDictList(DictData dictData, boolean reload) {
		Map<String, List<Map<String, Object>>> dictDataMap = (Map<String, List<Map<String, Object>>>) Static.redis.opsForValue().get(Contents.dictMap);
		
//		Map<String, List<Map<String, Object>>> dictDataMap = (Map<String, List<Map<String, Object>>>) CacheUtils.get(CACHE_DICT);
//		Map<String, List<Map<String, Object>>> dictDataMap = null;
		if (reload) {
			clearCache();
		}
		if (dictDataMap != null && dictDataMap.size() != 0) {
			return dictDataMap;
		} else {
			dictDataMap = MapUtils.newLinkedHashMap();
		}
//		dictDataMap = MapUtils.newLinkedHashMap();

//		Example example = new Example(DictData.class);
//		if (dictData.getTenantId() != null) {
//			example.and().andEqualTo("tenantId", dictData.getTenantId());
//		}
//		example.and().andEqualTo("status", DictData.STATUS_NORMAL);
//		example.or().andEqualTo("isSys", "1"); // 1系统内置 所有租户可见
//		example.setOrderByClause("tree_sort asc");
//		List<DictData> list = Static.dictDataService.selectByExample(example);
		
		
		List<DictData> list = Static.dictDataService
				.select(Wrappers.<DictData>lambdaQuery().eq(DictData::getStatus, DictData.STATUS_NORMAL).orderByAsc(DictData::getDictSort));
		
		
		if (list != null) {
			List<Map<String, Object>> targetList = null;
			Map<String, Object> e = null;
			for (DictData dd : list) {
				String dictType = dd.getDictType();
				if (dictDataMap.get(dictType) == null) {
					targetList = ListUtils.newLinkedList();
					e = MapUtils.newLinkedHashMap();
					e.put("dictLabel", dd.getDictLabel());
					e.put("dictValue", dd.getDictValue());
					e.put("cssClass", dd.getCssClass());
					e.put("cssStyle", dd.getCssStyle());
					targetList.add(e);
				} else {
					targetList = dictDataMap.get(dictType);
					e = MapUtils.newLinkedHashMap();
					e.put("dictLabel", dd.getDictLabel());
					e.put("dictValue", dd.getDictValue());
					e.put("cssClass", dd.getCssClass());
					e.put("cssStyle", dd.getCssStyle());
					targetList.add(e);
				}
				dictDataMap.put(dictType, targetList);
			}
			// 存储
//			Static.redis.opsForValue().set("tangdao:sysCache:dictMap", dictDataMap, -1L, TimeUnit.DAYS);
			Static.redis.opsForValue().set(Contents.dictMap, dictDataMap);
//			CacheUtils.put(CACHE_DICT, dictDataMap);
		}
		return dictDataMap;
	}

	public static void clearCache() {
		Static.redis.expire(Contents.dictMap, 0L, TimeUnit.SECONDS);
	}
}
