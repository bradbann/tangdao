package org.tangdao.modules.sys.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tangdao.common.config.Global;
import org.tangdao.common.service.impl.CrudServiceImpl;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.mapper.UserMapper;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.service.IUserService;
import org.tangdao.modules.sys.utils.UserUtils;

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
		User user = UserUtils.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("账号不存在");
		}
		return user;
	}

	public boolean checkUsernameExists(String oldUsername, String username) {
		if (username != null && username.equals(oldUsername)) {
			return true;
		} else if (username != null && this.count(Wrappers.<User>lambdaQuery().eq(User::getUsername, username)) == 0) {
			return true;
		}
		return false;
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
		return this.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
	}
	
	@Override
	public User getByUsercode(String userCode) {
		return this.getOne(Wrappers.<User>lambdaQuery().eq(User::getUserCode, userCode));
	}
	
	@Override
	public boolean saveOrUpdate(User user) {
		if(user.getIsNewRecord()) {
			String password = user.getPassword();
			if(StringUtils.isEmpty(password)) {
				password = Global.getConfig("sys.user.initPassword");
			}
			user.setPassword(password);
			if(StringUtils.isEmpty(user.getUserType())) {
				user.setUserType(User.USER_TYPE_NONE);
			}
			if(StringUtils.isEmpty(user.getMgrType())) {
				user.setMgrType(User.MGR_TYPE_NOT_ADMIN);
			}
		}
		return super.saveOrUpdate(user);
	}
	
	@Override
	public void saveAuth(User user) {
		if(StringUtils.isEmpty(user.getUserCode())) {
			return;
		}
		this.baseMapper.deleteUserRole(user.getUserCode());
		if(StringUtils.isNotBlank(user.getRoleCodes())) {
			this.baseMapper.insertUserRole(user.getUserCode(), user.getRoleCodes().split(","));
		}
	}
	
}
