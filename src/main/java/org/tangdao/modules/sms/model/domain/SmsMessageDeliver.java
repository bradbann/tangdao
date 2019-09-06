package org.tangdao.modules.sms.model.domain;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 回执推送信息Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_message_deliver")
public class SmsMessageDeliver extends DataEntity<SmsMessageDeliver> {
	
	private static final long serialVersionUID = 1L;
	
	private String deliverstatus;		// deliverStatus
	private String statusdes;		// statusDes
	private Long delivertimestart;		// deliverTimeStart
	private Long delivertimeend;		// deliverTimeEnd
	private String httptrytimes;		// httpTryTimes
	
	public SmsMessageDeliver() {
		super();
	}

	public SmsMessageDeliver(String id){
		super(id);
	}
	
	@Length(min=0, max=11, message="deliverStatus长度不能超过  11 个字符")
	public String getDeliverstatus() {
		return deliverstatus;
	}

	public void setDeliverstatus(String deliverstatus) {
		this.deliverstatus = deliverstatus;
	}
	
	@Length(min=0, max=500, message="statusDes长度不能超过  500 个字符")
	public String getStatusdes() {
		return statusdes;
	}

	public void setStatusdes(String statusdes) {
		this.statusdes = statusdes;
	}
	
	public Long getDelivertimestart() {
		return delivertimestart;
	}

	public void setDelivertimestart(Long delivertimestart) {
		this.delivertimestart = delivertimestart;
	}
	
	public Long getDelivertimeend() {
		return delivertimeend;
	}

	public void setDelivertimeend(Long delivertimeend) {
		this.delivertimeend = delivertimeend;
	}
	
	@Length(min=0, max=11, message="httpTryTimes长度不能超过  11 个字符")
	public String getHttptrytimes() {
		return httptrytimes;
	}

	public void setHttptrytimes(String httptrytimes) {
		this.httptrytimes = httptrytimes;
	}
	
}