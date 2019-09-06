package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 通道支持省份Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_passage_province")
public class SmsPassageProvince extends DataEntity<SmsPassageProvince> {
	
	private static final long serialVersionUID = 1L;
	
	private String passageId;		// 通道ID
	private String provinceCode;		// 省份代码
	
	public SmsPassageProvince() {
		super();
	}

	public SmsPassageProvince(String id){
		super(id);
	}
	
	@NotBlank(message="通道ID不能为空")
	@Length(min=0, max=11, message="通道ID长度不能超过  11 个字符")
	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}
	
	@Length(min=0, max=11, message="省份代码长度不能超过  11 个字符")
	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
}