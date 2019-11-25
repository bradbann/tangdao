package org.tangdao.modules.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tangdao.common.suports.BaseController;

@RestController
public class TokenController extends BaseController{
	
//	/**
//     * 权限管理
//     */
//    @Autowired
//    private AuthenticationManager authenticationManager;
    
//    @Autowired
//	private RedisOperations<String, Serializable> sessionRedisOperations;

	@PostMapping("/api/token")
	public Map<String, Object> token(
			@RequestParam("username") String username,
	        @RequestParam("password") String password,
	        HttpServletRequest request) {
//		//完成授权
//        final Authentication authentication = authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(username, password)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        
//        //获取当前登录用户所有的认证信息
//        final String tokenCreatedKey = SysRedisConstant.DEFAULT_NAMESPACE +"security:index:"+username;
//        Set<Serializable> set = this.sessionRedisOperations.boundSetOps(tokenCreatedKey).members();
//		if(set.size()>=5) {
//			throw new ServiceException("登录数超过限制 [5]");
//		}
//
//        final String secret = Global.getConfig("security.jwt.secret");
//        final Long expiration = Global.getConfigToLong("security.jwt.expiration","1728000");
////        Map<String, Object> claims = MapUtils.newHashMap();
//        final Date expirationDate = new Date(System.currentTimeMillis() + expiration.intValue());
//        final String token = Jwts.builder()
////	        .setClaims(claims)
//	        .setSubject(username)
//	        .setIssuedAt(new Date())
//	        .setExpiration(expirationDate)
//	        .signWith(SignatureAlgorithm.HS512, secret)
//	        .compact();
//        
//		//存储token
//		this.sessionRedisOperations.boundSetOps(tokenCreatedKey).add(token);
//		//获取用户信息
//		User user = UserUtils.getUser();
//		//记录登录日志
//		LogUtils.saveLog(user, request, "Token授权登录", Log.TYPE_ACCESS);
//		//存储token对应的用户信息
//		long time = new Date().getTime();
//		Map<String, Object> tokenInfo = MapUtils.newHashMap();
//		tokenInfo.put("tokenAttr:SPRING_SECURITY_CONTEXT", user);
//		tokenInfo.put("lastAccessedTime", time);
//		tokenInfo.put("maxInactiveInterval", expiration);
//		tokenInfo.put("creationTime", time);
//		tokenInfo.put("tokenAttr:host", IpUtils.getRemoteAddr(request));
//		tokenInfo.put("tokenAttr:deviceName", UserAgentUtils.getUserAgent(request).getOperatingSystem().getName());
//		sessionRedisOperations.boundHashOps(SysRedisConstant.TANGDAO_SECURITY_TOKENS + token).putAll(tokenInfo);
//		sessionRedisOperations.expire(SysRedisConstant.TANGDAO_SECURITY_TOKENS + token,  expiration, TimeUnit.SECONDS);
//        
//        Map<String, Object> data = MapUtils.newLinkedHashMap();
//		data.put("access_token", token);
//		data.put("expires_in", expiration);
//		data.put("token_type", "Bearer ");
//		data.put("username", user.getUsername());
//		data.put("user_code", user.getUserCode());
//		data.put("user_type", user.getUserType());
		return null;
	}
}
