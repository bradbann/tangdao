package org.tangdao.modules.sys.service;

import java.util.List;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sys.model.domain.Role;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
public interface IRoleService extends ICrudService<Role> {

	public List<Role> findByUserCode(String userCode);
	
	public boolean checkRoleNameExists(String oldRoleName, String roleName);
	
	public void insertRoleMenu(Role role, String[] menuCodes);
	
}
