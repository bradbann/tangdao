package org.tangdao.modules.sms.model.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 手机黑名单信息表Entity
 * @author ruyang
 * @version 2019-09-06
 */
@TableName("sms_mobile_blacklist")
public class SmsMobileBlacklist extends DataEntity<SmsMobileBlacklist> {
	
	private static final long serialVersionUID = 1L;
	
	private String mobile;		// 手机号码
	private String type;		// 类型
	private String remark;		// 备注
	
	public SmsMobileBlacklist() {
		super();
	}

	public SmsMobileBlacklist(String id){
		super(id);
	}
	
	@NotBlank(message="手机号码不能为空")
	@Length(min=0, max=16, message="手机号码长度不能超过  16 个字符")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@NotBlank(message="类型不能为空")
	@Length(min=0, max=4, message="类型长度不能超过  4 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=256, message="备注长度不能超过  256 个字符")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}