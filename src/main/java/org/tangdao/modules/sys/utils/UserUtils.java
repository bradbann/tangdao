package org.tangdao.modules.sys.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.tangdao.common.config.Global;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.ServletUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.model.domain.Menu;
import org.tangdao.modules.sys.model.domain.Role;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.service.IMenuService;
import org.tangdao.modules.sys.service.IRoleService;
import org.tangdao.modules.sys.service.IUserService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class UserUtils {
	
	private static final class Static {
		private static IUserService userService = SpringUtils.getBean(IUserService.class);
		private static IRoleService roleService = SpringUtils.getBean(IRoleService.class);
		private static IMenuService menuService = SpringUtils.getBean(IMenuService.class);
	}

	/**
	 * 当前登录用户
	 * 
	 * @return
	 */
	public static User getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof User) {
				return (User) principal;
			}
		}
		return null;
	}

	// 获取页面显示菜单
	public static List<Menu> getMenuTree() {
		List<Menu> targetList = new ArrayList<>();
		List<Menu> sourceList = getUser().getMenus().stream()
				.filter(menu -> Global.YES.equals(menu.getIsShow()) && Menu.TYPE_MENU.equals(menu.getMenuType()))
				.collect(Collectors.toList());
		Static.menuService.convertChildList(sourceList, targetList, Menu.ROOT_CODE);
		return targetList;
	}
	
	public static List<Menu> getMenuByParentCode(String parentCode) {
//		String sysId = ObjectUtils.toStringIgnoreNull(getSession().getAttribute("sysId"), Menu.SYS_ID_DEFAULT);
//		StringBuffer key = new StringBuffer("menuList_" + sysId);
//		if (StringUtils.isNotBlank(parentId)) {
//			key.append("_" + parentId);
//		}
//		List<Menu> list = (List<Menu>) UserUtils.getCache(key.toString());
//		if (list != null) {
//			return list;
//		}
//		Menu menu = new Menu();
//		menu.setSysId(sysId);
//		menu.setParentId(parentId);
		User user = null;
		List<Menu> menus = null;
		if(User.isSuperAdmin((user = getUser()).getUserCode())) {
			QueryWrapper<Menu> queryWrapper = new QueryWrapper<Menu>();
			queryWrapper.ne("status", Menu.STATUS_DELETE);
			queryWrapper.ge("weight", Menu.SUPER_ADMIN_GET_MENU_MIN_WEIGHT); //管理员获取的最小权重菜单，（用于有些菜单管理员不可查看，如财务报表等）
			
			queryWrapper.orderByAsc("tree_sort");
			menus = Static.menuService.select(queryWrapper);
		} else {
			// 获取用户类型指定默认角色
			Menu menu = new Menu();
			String defaultRoleCodes = Global.getConfig("sys.user.defaultRoleCodes." + user.getUserType());
			if (!User.USER_TYPE_NONE.equals(user.getUserType()) && StringUtils.isNotBlank(defaultRoleCodes)) {
				menu.setDefaultRoleCodes(Arrays.asList(StringUtils.split(defaultRoleCodes, ",")));
			}
			// 管理员角色追加
			if (user.isAdmin()) {
				Collection<String> roleCodes = menu.getDefaultRoleCodes();
				if (ListUtils.isEmpty(roleCodes)) {
					roleCodes = new ArrayList<>();
					menu.setDefaultRoleCodes(roleCodes);
				}
				roleCodes.add(Role.DEFAULT_ADMIN_ROLE_CODE);
				menu.setDefaultRoleCodes(roleCodes);
			}
			menu.setUserCode(user.getUserCode());
			menu.setParentCode(parentCode);
			menus = Static.menuService.findByUserMenu(menu, false);
		}
//		UserUtils.putCache(key.toString(), menus);
		return menus;
	}
	
	/**
	 * 根据用户编码获取用户信息
	 * @param userCode
	 * @return
	 */
	public static User getByUserCode(String userCode) {
		if (StringUtils.isBlank(userCode)) {
			return null;
		}
		Object obj;
		HttpServletRequest request = ServletUtils.getRequest();
		if (request != null && (obj = request.getAttribute("__user__" + userCode)) != null) {
			return (User) obj;
		} else {
			User user = null;
//			User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_USER_ID_ + userCode);
//			if (user != null) {
//				return (User) user.clone();
//			}
//			userCacheLock.lock();
//			try {
//				user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_USER_ID_ + userCode);
//				if (user != null) {
//					return (User) user.clone();
//				}
				user = Static.userService.get(userCode);
				if (user == null) {
					return null;
				}

				user.setRoles(Static.roleService.findByUserCode(userCode));
//				CacheUtils.put(USER_CACHE, USER_CACHE_USER_ID_ + user.getuserCode(), user);
//				CacheUtils.put(USER_CACHE, USER_CACHE_USERNAME_ + user.getUsername(), user.getuserCode());

				if (request != null) {
					request.setAttribute("__user__" + user.getUserCode(), user);
				}

				return (User) user.clone();
//			} finally {
//				userCacheLock.unlock();
//			}
		}
	}
	
	/**
	 * 根据用户名获取用户信息
	 * @param username
	 * @return
	 */
	public static User getByUsername(String username) {
		if (StringUtils.isBlank(username)) {
			return null;
		}
//		String userId = (String) CacheUtils.get(USER_CACHE, USER_CACHE_USERNAME_ + username);
//		if (StringUtils.isNotBlank(userId)) {
//			return UserUtils.get(userId);
//		}
//		userCacheLock.lock();
//		try {
//			userId = (String) CacheUtils.get(USER_CACHE, USER_CACHE_USERNAME_ + username);
//			if (StringUtils.isNotBlank(userId)) {
//				return UserUtils.get(userId);
//			}
//			User user = new User();
//			user.setUsername(username);
			User user = Static.userService.getUserByUsername(username);
			if (user == null) {
				return null;
			}

			user.setRoles(Static.roleService.findByUserCode(user.getUserCode()));
//			CacheUtils.put(USER_CACHE, USER_CACHE_USER_ID_ + user.getUserId(), user);
//			CacheUtils.put(USER_CACHE, USER_CACHE_USERNAME_ + user.getUsername(), user.getUserId());

			return (User) user.clone();
//
//		} finally {
//			userCacheLock.unlock();
//		}
	}
	
//	public void rc(HttpSession session) {
//		User user = getPrincipal();
//		if (user != null) { 
////			user.setMenus(menus);
//			SecurityContext securityContext = (SecurityContext) session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);  
//		    Authentication authentication = securityContext.getAuthentication(); 
//		    // 重新new一个token，因为Authentication中的权限是不可变的.  
//		    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(  
//		            user, authentication.getCredentials(),  
//		            authorityList);  
//		    result.setDetails(authentication.getDetails());  
//		    securityContext.setAuthentication(result); 
//	    }
//	}
	
	
}
