package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsMoMessageReceive extends DataEntity<SmsMoMessageReceive> {

	private static final long serialVersionUID = 2028793797084343535L;

	private String id;

	private String userCode;

	private String passageId;

	private String passageName;

	private String msgId;

	private String mobile;

	private String content;

	private String destnationNo;

	private String receiveTime;

	private Long createUnixtime;

	private String receiveTimeText;

	private Boolean needPush = false;

	private String pushUrl;
	
	private String sid;
	
	private Integer retryTimes;
	
	//短信上行推送
	private SmsMoMessagePush messagePush;

}