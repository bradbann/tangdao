package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 手机白名单信息表Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_mobile_whitelist")
public class SmsMobileWhitelist extends DataEntity<SmsMobileWhitelist> {
	
	private static final long serialVersionUID = 1L;
	
	private String mobile;		// mobile
	private String userCode;		// 用户编码
	
	public SmsMobileWhitelist() {
		super();
	}

	public SmsMobileWhitelist(String id){
		super(id);
	}
	
	@NotBlank(message="mobile不能为空")
	@Length(min=0, max=16, message="mobile长度不能超过  16 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=64, message="用户编码长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
}