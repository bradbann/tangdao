package org.tangdao.modules.sms.model.domain;

import java.util.Date;

import org.tangdao.common.suports.DataEntity;
import org.tangdao.common.utils.StringUtils;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 下行失败短信Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_api_failed_record")
public class SmsApiFailedRecord extends DataEntity<SmsApiFailedRecord> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String userCode;		// 用户编码
	private String appType;		// 调用类型
	private String submitType;		// 请求类型
	private String appKey;		// 接口账号
	private String appSecret;		// 接口密码
	private String mobile;		// 手机号
	private String timestamps;		// 提交时间戳
	private String content;		// content
	private String extNumber;		// 拓展号码
	private String attach;		// 自定义内容
	private String callback;		// 回调URL
	private String submitUrl;		// 程序调用URL
	private String ip;		// 提交IP
	private String respCode;		// 错误码
	
	public SmsApiFailedRecord() {
		super();
	}

	public SmsApiFailedRecord(String id){
		super(id);
	}
	
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