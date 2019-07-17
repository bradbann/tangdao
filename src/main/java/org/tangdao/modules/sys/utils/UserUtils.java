package org.tangdao.modules.sys.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.tangdao.modules.sys.model.domain.User;

public class UserUtils {

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
}
