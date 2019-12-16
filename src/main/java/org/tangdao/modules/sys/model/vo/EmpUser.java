/**
 *
 */
package org.tangdao.modules.sys.model.vo;

import org.tangdao.modules.sys.model.domain.Company;
import org.tangdao.modules.sys.model.domain.Employee;
import org.tangdao.modules.sys.model.domain.Office;
import org.tangdao.modules.sys.model.domain.User;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Ryan Ru(ruyangit@gmail.com)
 */
@Getter
@Setter
public class EmpUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Employee employee;
	
	private Company company;
	
	private Office office;
}
