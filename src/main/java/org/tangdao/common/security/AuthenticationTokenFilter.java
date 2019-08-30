package org.tangdao.common.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;
import org.tangdao.common.config.Contents;
import org.tangdao.common.config.Global;
import org.tangdao.common.utils.ServletUtils;
import org.tangdao.common.utils.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthenticationTokenFilter extends OncePerRequestFilter {
	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;

	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //过滤掉不需要token验证的url
        /*if(authenticationRequestMatcher != null && !authenticationRequestMatcher.matches(httpServletRequest)){
            filterChain.doFilter(request, response);
            return;
        }*/
		String tokenHeader = request.getHeader("Authorization");
		String accessToken = request.getParameter("access_token");
		if (StringUtils.isBlank(accessToken)) {
			if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
				filterChain.doFilter(request, response);
				return;
			}
		}
		
		//过滤掉指定方法不做校验
		final String tokenValue = StringUtils.isNotBlank(accessToken) ? accessToken : StringUtils.substring(tokenHeader, 7);
		if(tokenValue == null) {
			filterChain.doFilter(request, response);
			return;
		}
		final String secret = Global.getConfig("security.jwt.secret");
		Claims claims = null;
		try {
			claims = Jwts.parser()
			    .setSigningKey(secret)
			    .parseClaimsJws(tokenValue)
			    .getBody();
			
		} catch (Exception e) {
			response.setStatus(401);
			org.slf4j.LoggerFactory.getLogger("Status code [401]").error(e.getMessage(), e);
			ServletUtils.renderResult(response, Global.FALSE, "Claims信息获取失败，原因：" + e.getMessage());
			return;
		}
		
		if(claims!=null && claims.getExpiration().before(new Date())) {
			response.setStatus(401);
			org.slf4j.LoggerFactory.getLogger("Status code [401]").error("认证信息已经过期，请重新登录！");
			ServletUtils.renderResult(response, Contents.EC_TOKEN_EXPIRATION, "认证信息已经过期，请重新登录！");
			return;
		}
		final String username = claims.getSubject();
		System.out.println(username);
//		UserDetails userDetails = (UserDetails) redisTemplate.opsForValue().get(Contents.TANGDAO_SECURITY_TOKENS + username);
//		
//		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		filterChain.doFilter(request, response);
    }
}
