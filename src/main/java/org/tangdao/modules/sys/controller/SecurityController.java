package org.tangdao.modules.sys.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.tangdao.common.suports.BaseController;

@Controller
public class SecurityController extends BaseController {

	@GetMapping("/login")
	public String login() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}
		return "modules/sysLogin";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = { "/" })
	public String index(Principal principal) {
		return "modules/sysIndex";
	}
}
