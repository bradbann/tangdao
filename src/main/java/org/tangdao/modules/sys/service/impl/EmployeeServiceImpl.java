package org.tangdao.modules.sys.service.impl;

import org.springframework.stereotype.Service;

import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.sys.service.IEmployeeService;
import org.tangdao.modules.sys.model.domain.Employee;
import org.tangdao.modules.sys.model.vo.EmpUser;
import org.tangdao.modules.sys.mapper.EmployeeMapper;

/**
 * 员工ServiceImpl
 * @author ruyang
 * @version 2019-12-16
 */
@Service
public class EmployeeServiceImpl extends CrudServiceImpl<EmployeeMapper, Employee> implements IEmployeeService{
		
	@Override
	public Page<EmpUser> findEmpUserPage(Page<Employee> page, EmpUser empUser) {
		return super.getBaseMapper().findEmpUserPage(page, empUser);
	}
}