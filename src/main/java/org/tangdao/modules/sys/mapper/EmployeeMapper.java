package org.tangdao.modules.sys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tangdao.common.suports.Page;
import org.tangdao.modules.sys.model.domain.Employee;
import org.tangdao.modules.sys.model.vo.EmpUser;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 员工Mapper接口
 * 
 * @author ruyang
 * @version 2019-12-16
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

	public Page<EmpUser> findEmpUserPage(Page<Employee> page, EmpUser empUser);
	
}