package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 回执推送信息Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_message_deliver")
public class SmsMessageDeliver extends DataEntity<SmsMessageDeliver> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
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
}