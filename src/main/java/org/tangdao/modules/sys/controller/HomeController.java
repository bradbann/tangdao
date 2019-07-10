package org.tangdao.modules.sys.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tangdao.common.suports.BaseController;

@Controller
@PreAuthorize("isAuthenticated()")
public class HomeController extends BaseController {

	@GetMapping(value = { "/" })
	public ModelAndView index(Principal principal) {
		return this.view("modules/sysIndex");
	}
}
