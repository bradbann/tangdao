package org.tangdao.modules.exchanger.template.handler;

import org.apache.commons.lang3.StringUtils;
import org.tangdao.modules.exchanger.exception.DataEmptyException;
import org.tangdao.modules.exchanger.exception.DataParseException;
import org.tangdao.modules.exchanger.template.vo.TParameter;

import com.alibaba.fastjson.JSON;

/**
 * 
  * TODO 参数请求解析器
  * 
  * @author ruyang
  * @version V1.0   
  * @date 2016年9月28日 下午2:56:23
 */
public class RequestTemplateHandler {

	public static TParameter parse(String parameter) {
		
		validate(parameter);
		
		try {
			return JSON.parseObject(parameter, TParameter.class);
		} catch (Exception e) {
			throw new DataParseException(e);
		}
	}

	private static void validate(String parameter) {
		if (StringUtils.isEmpty(parameter)) {
            throw new DataEmptyException("参数数据为空");
        }
	}
		
}
