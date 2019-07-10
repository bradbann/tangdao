package org.tangdao.modules.sys.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.tangdao.common.suports.BaseController;

@Controller
public class SecurityController extends BaseController {
	
    @GetMapping("/login")
    public ModelAndView login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return this.view("redirect:/");
        }
        return this.view("modules/sysLogin");
    }
}
