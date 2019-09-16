package org.tangdao.modules.sms.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sms.model.domain.SmsPassageMessageTemplate;

/**
 * 通道消息模板Service
 * @author ruyang
 * @version 2019-09-06
 */
public interface ISmsPassageMessageTemplateService extends ICrudService<SmsPassageMessageTemplate> {
	/**
	 * 
	   * TODO 添加通道短信模板
	   * 
	   * @param passageMessageTemplate
	   * @return
	 */
	boolean save(SmsPassageMessageTemplate smsPassageMessageTemplate);

	/**
	 * 
	   * TODO 修改通道短信模板
	   * 
	   * @param passageMessageTemplate
	   * @return
	 */
	boolean update(SmsPassageMessageTemplate smsPassageMessageTemplate);

	/**
	 * 删除通道短信模板
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(String id);

	/**
	 * 
	   * TODO 根据通道ID查询所有的通道短信模板信息
	   * 
	   * @param passageId
	   * @return
	 */
	List<SmsPassageMessageTemplate> findByPassageId(String passageId);

	/**
	 * 
	   * TODO 根据短信模板ID获取通道短信模板信息
	   * @param templateId
	   * @return
	 */
	SmsPassageMessageTemplate getByTemplateId(String templateId);
	
	/**
	 * 
	   * TODO 根据短信内容获取通道短信模板信息
	   * 
	   * @param passageId
	   * 		通道ID
	   * @param messageContent
	   * 		模板内容
	   * @return
	 */
	SmsPassageMessageTemplate getByMessageContent(String passageId, String messageContent);

	/**
	 * 
	 * TODO 判断输入内容是否符合模板内容
	 * 
	 * @param id
	 * @param content
	 * @return
	 */
	boolean isContentMatched(String id, String content);

	/**
	 * 
	   * TODO 重新加载到REDIS
	   * 
	   * @return
	 */
	boolean reloadToRedis();
}