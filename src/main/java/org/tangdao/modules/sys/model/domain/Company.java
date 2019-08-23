package org.tangdao.modules.sys.model.domain;

import org.hibernate.validator.constraints.Length;

import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.suports.TreeName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 公司Entity
 * @author ruyang
 * @version 2019-08-23
 */
@TableName("sys_company")
public class Company extends TreeEntity<Company> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String companyCode;		// 公司编码
	private String viewCode;		// 公司代码
	@TreeName
	private String companyName;		// 公司名称
	private String fullName;		// 公司全称
	private String areaCode;		// 区域编码
	
	public Company() {
		super();
	}

	public Company(String companyCode){
		super(companyCode);
	}
	
	@Override
	public Company getParent() {
		return parent;
	}

	
	@Length(min=0, max=64, message="公司编码长度必须介于 0 和 64 之间")
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	@Length(min=1, max=100, message="公司代码长度必须介于 1 和 100 之间")
	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}
	
	@Length(min=0, max=200, message="公司名称长度必须介于 0 和 200 之间")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Length(min=1, max=200, message="公司全称长度必须介于 1 和 200 之间")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Length(min=1, max=100, message="区域编码长度必须介于 1 和 100 之间")
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
}