package org.tangdao.modules.sys.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.tangdao.modules.sys.model.domain.User;

public class UserUtils {
	
//	private static final class Static {
////		private static UserService userService = SpringUtils.getBean(UserService.class);
////		private static RoleService roleService = SpringUtils.getBean(RoleService.class);
//		private static IMenuService menuService = SpringUtils.getBean(IMenuService.class);
//	}

	/**
	 * 当前登录用户
	 * 
	 * @return
	 */
	public static User getUser() {
		return getPrincipal();
	}

	public static User getPrincipal() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal != null) {
			if (principal instanceof User) {
				return (User) principal;
			}
		}
		return null;
	}
	
//	// 获取页面显示菜单
//	public static List<Menu> getMenuTree() {
//		List<Menu> targetList = new ArrayList<>();
//		List<Menu> sourceList = findMenuByParentCode(null).stream()
//				.filter(menu -> Global.YES.equals(menu.getIsShow()) && Menu.TYPE_MENU.equals(menu.getMenuType()))
//				.collect(Collectors.toList());
//		Static.menuService.convertChildList(sourceList, targetList, Menu.ROOT_CODE);
//		return targetList;
//	}
	
}
