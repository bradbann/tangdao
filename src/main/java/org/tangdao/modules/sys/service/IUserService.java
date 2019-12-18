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

	/**
	 * 	检查用户名是否已经存在
	 * @param oldUsername
	 * @param username
	 * @return
	 */
	boolean checkUsernameExists(String oldUsername, String username);
	
	/**
	 * 根据用户名获取用户信息
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);
	
	/**
	 *  更新用户级别信息
	 * @param user
	 */
	public void updateUserinfo(User user);
	
	/**
	 * 更新用户登录信息
	 * @param user
	 */
	public void updateLoginUserinfo(User user);
	
	/**
	 * 更新用户密码
	 * @param userCode
	 * @param password
	 */
	public void updatePassword(String userCode, String password);
	
	/**
	 * 根据用户主键获取用户信息
	 * @param userCode
	 * @return
	 */
	public User getByUsercode(String userCode);
	
	/**
	 *  保存用户角色授权
	 * @param user
	 */
	public void saveAuth(User user);
	
}
