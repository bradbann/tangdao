package org.tangdao.modules.sms.model.domain;

import java.io.Serializable;
import java.util.Date;

import org.tangdao.modules.sys.model.domain.User;

import lombok.Data;

@Data
public class SmsPassageAccess implements Serializable {

	private static final long serialVersionUID = -4609147131830713940L;

	private String id;

	private String userCode;

	private String groupId;

	private String routeType;

	private String cmcp;

	private String passageId;

	private String passageCode;

	private String protocol;

	private String callType;

	private String url;

	private String paramsDefinition;

	private String params;

	private String resultFormat;

	private String successCode;

	private String position;

	private Integer mobileSize;

	private Integer packetsSize;
	
	private Integer connectionSize;
	
	// add by 20170831 请求响应超时时间（毫秒）
	private Integer readTimeout;

	private String accessCode;

	private Integer extNumber;

	private Integer signMode;

	private Date createTime;
	
	private String status;
	
	// 是否需要通道方短信模板参数
	private Integer smsTemplateParam;

	private String userIdText;
	private String passageIdText;

	private Integer provinceCode;
	private String provinceName;
	private String cmcpName;
	private String routeTypeText;
	
	private User user;

}