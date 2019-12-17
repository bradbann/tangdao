package org.tangdao.modules.sys.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.sys.model.domain.Employee;
import org.tangdao.modules.sys.model.vo.EmpUser;

/**
 * 员工Service
 * @author ruyang
 * @version 2019-12-16
 */
public interface IEmployeeService extends ICrudService<Employee> {
		
	/**
	 * 员工分页列表
	 * @param page
	 * @param empUser
	 * @return
	 */
	public Page<EmpUser> findEmpUserPage(Page<Employee> page, EmpUser empUser);
	
	/**
	 *  员工信息
	 * @param userCode
	 * @return
	 */
	public EmpUser getEmpUserByUserCode(String userCode, boolean isNewRecord);
	
	/**
	 * 保存员工
	 * @param empUser
	 */
	public void saveEmpUser(EmpUser empUser);

}