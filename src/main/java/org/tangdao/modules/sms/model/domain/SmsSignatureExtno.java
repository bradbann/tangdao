package org.tangdao.modules.sms.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 签名扩展Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_signature_extno")
public class SmsSignatureExtno extends DataEntity<SmsSignatureExtno> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String userCode;		// 用户编码
	private String signature;		// 签名
	private String extNumber;		// 扩展号码
	
	public SmsSignatureExtno() {
		super();
	}

	public SmsSignatureExtno(String id){
		super(id);
	}
}