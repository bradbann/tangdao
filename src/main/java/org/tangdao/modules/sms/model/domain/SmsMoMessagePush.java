package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 上行消息推送Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_mo_message_push")
public class SmsMoMessagePush extends DataEntity<SmsMoMessagePush> {
	
	private static final long serialVersionUID = 1L;
	
	private String msgId;		// 消息ID
	private String mobile;		// 手机号码
	private String content;		// 推送内容
	private String retryTimes;		// 重试次数
	private Long responseMilliseconds;		// 推送相应时间
	private String responseContent;		// 响应内容
	
	public SmsMoMessagePush() {
		super();
	}

	public SmsMoMessagePush(String id){
		super(id);
	}
	
	@Length(min=0, max=64, message="消息ID长度不能超过  64 个字符")
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@NotBlank(message="手机号码不能为空")
	@Length(min=0, max=6000, message="手机号码长度不能超过  6000 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@NotBlank(message="推送内容不能为空")
	@Length(min=0, max=1024, message="推送内容长度不能超过  1024 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Length(min=0, max=4, message="重试次数长度不能超过  4 个字符")
	public String getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(String retryTimes) {
		this.retryTimes = retryTimes;
	}
	
	public Long getResponseMilliseconds() {
		return responseMilliseconds;
	}

	public void setResponseMilliseconds(Long responseMilliseconds) {
		this.responseMilliseconds = responseMilliseconds;
	}
	
	@Length(min=0, max=1024, message="响应内容长度不能超过  1024 个字符")
	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}
	
}