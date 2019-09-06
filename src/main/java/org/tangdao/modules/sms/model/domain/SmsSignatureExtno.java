package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 签名扩展Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_signature_extno")
public class SmsSignatureExtno extends DataEntity<SmsSignatureExtno> {
	
	private static final long serialVersionUID = 1L;
	
	private String userCode;		// 用户编码
	private String signature;		// 签名
	private String extNumber;		// 扩展号码
	
	public SmsSignatureExtno() {
		super();
	}

	public SmsSignatureExtno(String id){
		super(id);
	}
	
	@NotBlank(message="用户编码不能为空")
	@Length(min=0, max=64, message="用户编码长度不能超过  64 个字符")
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@NotBlank(message="签名不能为空")
	@Length(min=0, max=64, message="签名长度不能超过  64 个字符")
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	@NotBlank(message="扩展号码不能为空")
	@Length(min=0, max=16, message="扩展号码长度不能超过  16 个字符")
	public String getExtNumber() {
		return extNumber;
	}

	public void setExtNumber(String extNumber) {
		this.extNumber = extNumber;
	}
	
}