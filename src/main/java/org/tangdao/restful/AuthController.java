package org.tangdao.restful;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;

@RestController
public class AuthController extends BaseController{

	@PostMapping("/api/token")
	public String auth() {
		return renderResult(Global.TRUE, "登录成功！");
	}
}
