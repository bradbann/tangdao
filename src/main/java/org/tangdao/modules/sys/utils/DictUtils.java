package org.tangdao.modules.sys.utils;

import java.util.List;
import java.util.Map;

import org.tangdao.common.utils.JsonMapper;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.DictData;
import org.tangdao.modules.sys.service.IDictDataService;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;

public class DictUtils {

	private static final class Static {
		private static IDictDataService dictDataService = SpringUtils.getBean(IDictDataService.class);
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
			List<JSONObject> list = getDictList(dictType);
			if (list != null) {
				for (JSONObject map : list) {
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
			List<JSONObject> list = getDictList(dictType);
			if (list != null) {
				for (JSONObject map : list) {
					if (map.containsKey(dictLabel)) {
						return String.valueOf(map.get("dictValue"));
					}
				}
			}
		}
		return defaultValue;
	}

	public static List<JSONObject> getDictList(String dictType) {
		Map<String, List<JSONObject>> dictDataMap = Static.dictDataService.getDictDataList();
		if (dictDataMap != null && dictDataMap.size() != 0) {
			List<JSONObject> list = dictDataMap.get(dictType);
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
	
	public static void clearCache() {
		Static.dictDataService.clearCache();
	}
}
