package org.tangdao.modules.sys.service;

import org.tangdao.common.service.ICurdService;
import org.tangdao.modules.sys.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
public interface IUserService extends ICurdService<User> {

	public boolean checkEmailExists(String email);
	public boolean checkMobileExists(String mobile);
	public boolean checkUsernameExists(String username);
	
	public User getUserByUsername(String username);
	
	public void registerUser(User user);
	
	public void updateUserinfo(User user);
	
	public void updateLoginUserinfo(User user);
	
	public void updatePassword(String userCode, String password);
	
}
