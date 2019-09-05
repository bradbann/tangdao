package org.tangdao.modules.sms.model.domain;

import java.util.Date;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsApiFailedRecord extends DataEntity<SmsApiFailedRecord> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String usrCode;

	private String appType;

	private String submitType;

	private String appKey;

	private String appSecret;

	private String mobile;

	private String timestamps;

	private String content;

	private String extNumber;

	private String attach;

	private String callback;

	private String submitUrl;

	private String ip;

	private String respCode;

	private String errorCodeText;

	public String[] getMobiles(){
		if(StringUtils.isNotBlank(mobile)){
			return mobile.split(",");
		}
		return null;
	}

	public String getFirstMobile(){
		String[] mobiles = getMobiles();
		if(mobiles != null && mobiles.length > 0){
			return mobiles[0];
		}
		return mobile;
	}

	public Date getSubmitTime(){
		if(StringUtils.isNotBlank(timestamps)){
			long t = Long.valueOf(timestamps);
			return new Date(t);
		}
		return null;
	}
}
