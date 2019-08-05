package org.tangdao.modules.sys.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tangdao.common.service.impl.CrudServiceImpl;
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
	
//	@Autowired
//	private PasswordEncoderService passwordEncoderService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = UserUtils.getByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("账号不存在");
		}
		
//		String plainPassword = ServletUtils.getParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY);
//		if(!passwordEncoderService.validatePassword(plainPassword, user.getPassword())) {
//			throw new BadCredentialsException("密码认证失败");
//		}
//		
//		if (User.STATUS_DISABLE.equals(user.getStatus())) { // DisabledException LockedException
//			throw new DisabledException("用户被禁用");
//		} else if (User.STATUS_FREEZE.equals(user.getStatus())) { // DisabledException LockedException
//			throw new DisabledException("用户被冻结");
//		} else if (!User.STATUS_NORMAL.equals(user.getStatus())) { // DisabledException LockedException
//			throw new AccountExpiredException("用户暂时无法操作，请联管理员");
//		}
		//获取权限信息
//		user.setMenus(UserUtils.findByParentCode(null));
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
	

//	@Override
//	public Page<User> findPage(User user, Wrapper<User> queryWrapper) {
//		Page<User> pageUser = super.findPage(user, queryWrapper);
//		List<User> listUser = pageUser.getData();
//		Role r = null;
//		for (User u : listUser) {
//			r = new Role();
//			r.setUserCode(u.getUserCode());
//			u.setRoles(roleService.findByUserCode(r));
//		}
//		return pageUser;
//	}

}
