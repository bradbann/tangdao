package org.tangdao.modules.sms.model.vo;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * TODO 用户手机号码处理的最后一条短信(1天内)
 *
 * @author ruyang
 * @version V1.0.0
 * @date 2016年9月6日 上午1:00:34
 */
@Data
public class SmsLastestRecordVo implements Serializable {

	private static final long serialVersionUID = 3102409004246718641L;
	private String userCode;
	private String mobile;
	private String content;
	private String createTime;
	private String nodeTime;
	private MessageNode messageNode;
	private String descrption;

	/**
	 * 
	 * TODO 短信节点
	 *
	 * @author zhengying
	 * @version V1.0.0
	 * @date 2016年9月6日 上午12:59:55
	 */
	public enum MessageNode {
		API_CALLING, API_CALL_FAILED, SMS_CREATE, SMS_SUBMITING, SMS_SUBMIT_FAILED,

		SMS_SEND_GATEWAY, SMS_GATEWAY_RECEIVE_FAILED, SMS_COMPLETE
	}

}
