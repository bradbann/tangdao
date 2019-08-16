package org.tangdao.modules.sys.web;

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
import org.tangdao.common.annotation.DbSaveLog;
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
	@DbSaveLog(logIgnore = true)
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String queryString = request.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
			ServletUtils.redirectUrl(request, response, adminPath + "/index" + queryString);
			return null;
		}
		
		// 如果是Ajax请求，返回Json字符串。
		if (ServletUtils.isAjaxRequest((HttpServletRequest) request)) {
			model.addAttribute("result", "login");
			model.addAttribute("message", "未登录或登录超时。请重新登录，谢谢！");
			return ServletUtils.renderObject(response, model);
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
	@DbSaveLog(logIgnore = true)
	@PreAuthorize("isAuthenticated()")
//	@PreAuthorize("hasRole('ROLE_USER') and hasAuthority('sys:menu:edit') and isAuthenticated()")
	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = UserUtils.getUser();
		if (user == null) {
			String queryString = request.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
			ServletUtils.redirectUrl(request, response, adminPath + "/login" + queryString);
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
	@DbSaveLog(logIgnore = true)
	@RequestMapping(value = "desktop")
	public String desktop(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/sysDesktop";
	}
}
