package org.tangdao.modules.sys.model.domain;

import org.tangdao.common.suports.TreeEntity;
import org.tangdao.common.suports.TreeName;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 公司Entity
 * @author ruyang
 * @version 2019-08-28
 */
@TableName("sys_company")
public class Company extends TreeEntity<Company> {
	
	private static final long serialVersionUID = 1L;
	
	@TreeName
	private String companyName;		// 公司名称
	@TableId
	private String companyCode;		// 公司编码
	private String fullName;		// 公司全称
	private String viewCode;		// 公司代码
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

	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getViewCode() {
		return viewCode;
	}

	public void setViewCode(String viewCode) {
		this.viewCode = viewCode;
	}
	
	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	
}