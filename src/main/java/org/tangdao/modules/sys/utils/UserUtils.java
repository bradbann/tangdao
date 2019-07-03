package org.tangdao.modules.sys.utils;

import org.tangdao.modules.sys.entity.User;

public class UserUtils {

	/**
	 * 当前登录用户
	 * @return
	 */
	public static User getUser() {
		return new User();
	}
}
