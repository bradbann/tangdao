package org.tangdao.modules.sys.model.domain;

import org.tangdao.common.suports.DataEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Getter;
import lombok.Setter;

/**
 * 员工Entity
 * @author ruyang
 * @version 2019-12-16
 */
@Getter
@Setter
@TableName("sys_employee")
public class Employee extends DataEntity<Employee> {
	
	private static final long serialVersionUID = 1L;
	
	@TableId
	private String empCode;		// 员工编码
	private String empName;		// 员工姓名
	private String empNameEn;		// 英文名
	private String officeCode;		// 机构编码
	private String officeName;		// 机构名称
	private String companyCode;		// 公司编码
	private String companyName;		// 公司名称
	
	@TableField(exist = false)
	private Company company;
	
	@TableField(exist = false)
	private Office office;
	
	public Employee() {
		super();
	}

	public Employee(String empCode){
		super(empCode);
	}
}