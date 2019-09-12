package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.exchanger.config.CommonContext.PassageCallType;
import org.tangdao.modules.sms.model.domain.SmsPassageParameter;

/**
 * 通道消息模板参数Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsPassageParameterService extends ICrudService<SmsPassageParameter> {
		
	/**
	 * 根据通道id获取通道参数
	 * 
	 * @param passageId
	 * @return
	 */
	List<SmsPassageParameter> findByPassageId(String passageId);

	/**
	 * 
	 * TODO 根据通道代码获取参数详细信息（主要针对回执报告和上行信息）
	 * 
	 * @param passageCode
	 *            通道代码（当通道调用类型为 状态回执推送 或 上行推送时，passage_url 值为 通道代码[唯一]）
	 * @param callType
	 *            通道调用类型，本例主要用于[状态回执推送,上行推送]
	 * @return
	 */
	SmsPassageParameter getByType(PassageCallType callType, String passageCode);
	
	boolean deleteByPassageId(String passageId);
}