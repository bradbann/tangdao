package org.tangdao.restful;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.modules.sys.model.domain.Log;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.utils.LogUtils;
import org.tangdao.modules.sys.utils.UserUtils;

@RestController
public class TokenController extends BaseController{
	
	/**
     * 权限管理
     */
    @Autowired
    private AuthenticationManager authenticationManager;

	@PostMapping("/api/token")
	public String token(
			@RequestParam("username") String username,
	        @RequestParam("password") String password,
	        HttpServletRequest request) {
		//完成授权
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = UserUtils.getUser();
        LogUtils.saveLog(user, request, "Token授权登录", Log.TYPE_ACCESS);
        
        
		return renderResult(Global.TRUE, "登录成功！", user);
	}
}
