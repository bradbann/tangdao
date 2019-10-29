package org.tangdao.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tangdao.modules.sys.utils.UserUtils;

@Controller
@RequestMapping("${adminPath}")
public class UserinfoController {

	@RequestMapping("userinfo")
	public String userinfo(Model model) {
		model.addAttribute("user", UserUtils.getUser());
		return "modules/sysUserinfo";
	}
}
