package org.tangdao.modules.sys.service;

import org.tangdao.common.service.ICrudService;
import org.tangdao.modules.sys.model.domain.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
public interface IUserService extends ICrudService<User> {

	boolean checkUsernameExists(String oldUsername, String username);
	
	public User getUserByUsername(String username);
	
	public void registerUser(User user);
	
	public void updateUserinfo(User user);
	
	public void updateLoginUserinfo(User user);
	
	public void updatePassword(String userCode, String password);
	
	public User getByUsercode(String userCode);
	
}
