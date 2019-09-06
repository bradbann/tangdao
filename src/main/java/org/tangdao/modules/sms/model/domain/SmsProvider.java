package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 短信接口提供商Entity
 * @author ruyang
 * @version 2019-09-06
 */
@Getter
@Setter
@TableName("sms_provider")
public class SmsProvider extends DataEntity<SmsProvider> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String id;
	
	private String type;		// 提供商类型0:运营商1:第三方
	private String name;		// 提供商名称
	private String code;		// 提供商编号
	private String isApplied;		// 是否启用(0:启用1:停用)
	private String priority;		// 优先级(相同产品调用优先级)
	private String contact;		// contact
	private String phone;		// phone
	private String mobile;		// mobile
	private String fax;		// fax
	private String address;		// address
	private String zip;		// zip
	
	public SmsProvider() {
		super();
	}

	public SmsProvider(String id){
		super(id);
	}
	
	@NotBlank(message="提供商类型0:运营商1:第三方不能为空")
	@Length(min=0, max=4, message="提供商类型0:运营商1:第三方长度不能超过  4 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@NotBlank(message="提供商名称不能为空")
	@Length(min=0, max=45, message="提供商名称长度不能超过  45 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="提供商编号不能为空")
	@Length(min=0, max=45, message="提供商编号长度不能超过  45 个字符")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@NotBlank(message="是否启用(0:启用1:停用)不能为空")
	@Length(min=0, max=4, message="是否启用(0:启用1:停用)长度不能超过  4 个字符")
	public String getIsApplied() {
		return isApplied;
	}

	public void setIsApplied(String isApplied) {
		this.isApplied = isApplied;
	}
	
	@NotBlank(message="优先级(相同产品调用优先级)不能为空")
	@Length(min=0, max=4, message="优先级(相同产品调用优先级)长度不能超过  4 个字符")
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@NotBlank(message="contact不能为空")
	@Length(min=0, max=45, message="contact长度不能超过  45 个字符")
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	@Length(min=0, max=45, message="phone长度不能超过  45 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=45, message="mobile长度不能超过  45 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Length(min=0, max=45, message="fax长度不能超过  45 个字符")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@NotBlank(message="address不能为空")
	@Length(min=0, max=45, message="address长度不能超过  45 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=45, message="zip长度不能超过  45 个字符")
	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
}