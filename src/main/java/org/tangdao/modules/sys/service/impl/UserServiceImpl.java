package org.tangdao.modules.sys.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.modules.sys.entity.User;
import org.tangdao.modules.sys.mapper.UserMapper;
import org.tangdao.modules.sys.service.IUserService;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ruyang
 * @since 2019-07-02
 */
@Service
public class UserServiceImpl extends CrudServiceImpl<UserMapper, User> implements IUserService, UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username).or()
				.eq(User::getMobile, username).or().eq(User::getEmail, username));
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

	@Override
	public boolean checkEmailExists(String email) {
		// TODO Auto-generated method stub
		return this.count(Wrappers.<User>lambdaQuery().eq(User::getEmail, email)) > 0;
	}

	@Override
	public boolean checkMobileExists(String mobile) {
		// TODO Auto-generated method stub
		return this.count(Wrappers.<User>lambdaQuery().eq(User::getMobile, mobile)) > 0;
	}

	@Override
	public boolean checkUsernameExists(String username) {
		// TODO Auto-generated method stub
		return this.count(Wrappers.<User>lambdaQuery().eq(User::getUsername, username)) > 0;
	}

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserinfo(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLoginUserinfo(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(String userCode, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUserByUsername(String username) {
		
		return null;
	}

}
