package org.tangdao.modules.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.utils.ServletUtils;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value = "${adminPath}")
public class LoginController extends BaseController {

	/**
	 * 登录页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return REDIRECT + Global.getConfig("web.defaultPath", "/");
		}
		return "modules/sysLogin";
	}

	/**
	 * 首页
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = { "index", "console" })
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (user == null) {
			String queryString = request.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
			ServletUtils.redirectUrl(request, response, "/login" + queryString);
			return null;
		}
		model.addAttribute("user", user); // 设置当前用户信息
		model.addAttribute("menus", UserUtils.getMenuTree()); // 菜单信息
		return "modules/sysIndex";
	}
	
	/**
	 * 我的桌面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = "desktop")
	public String desktop(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/sysDesktop";
	}
}
