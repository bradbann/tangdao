package org.tangdao.common.web.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tangdao.common.suports.BaseController;

@Controller
@PreAuthorize("isAuthenticated()")
public class HomeController extends BaseController {

	@GetMapping(value = { "/", "/index", "/home" })
	public ModelAndView index(Principal principal) {
		return this.view("home/index");
	}
}
