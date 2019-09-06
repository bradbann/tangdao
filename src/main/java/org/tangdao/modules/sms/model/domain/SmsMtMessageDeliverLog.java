package org.tangdao.modules.sms.model.domain;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 下行短信回执状态日志Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_mt_message_deliver_log")
public class SmsMtMessageDeliverLog extends DataEntity<SmsMtMessageDeliverLog> {
	
	private static final long serialVersionUID = 1L;
	
	private String passageCode;		// 通道简码
	private String msgId;		// 消息ID
	private String deliverTime;		// 短信提供商回复的时间，可为空
	private String report;		// 报文数据
	
	public SmsMtMessageDeliverLog() {
		super();
	}

	public SmsMtMessageDeliverLog(String id){
		super(id);
	}
	
	@Length(min=0, max=32, message="通道简码长度不能超过  32 个字符")
	public String getPassageCode() {
		return passageCode;
	}

	public void setPassageCode(String passageCode) {
		this.passageCode = passageCode;
	}
	
	@Length(min=0, max=64, message="消息ID长度不能超过  64 个字符")
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@Length(min=0, max=32, message="短信提供商回复的时间，可为空长度不能超过  32 个字符")
	public String getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	
}