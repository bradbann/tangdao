package org.tangdao.modules.sys.model.domain;

import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.suports.TreeName;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 机构Entity
 * @author ruyang
 * @version 2019-08-24
 */
@TableName("sys_office")
public class Office extends TreeEntity<Office> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String officeCode;		// 机构编码
	private String viewCode;		// 机构代码
	@TreeName
	private String officeName;		// 机构名称
	private String fullName;		// 机构全称
	private String officeType;		// 机构类型
	private String leader;		// 负责人
	private String phone;		// 办公电话
	private String address;		// 联系地址
	private String zipCode;		// 邮政编码
	private String email;		// 电子邮箱
	
	public Office() {
		super();
	}

	public Office(String officeCode){
		super(officeCode);
	}
	
	@Override
	public Office getParent() {
		return parent;
	}
	
	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	
	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}
	
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getOfficeType() {
		return officeType;
	}

	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}
	
	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}