package org.tangdao.config;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.tangdao.common.utils.IpUtils;
import org.tangdao.common.utils.UserAgentUtils;
import org.tangdao.modules.sys.model.domain.Log;
import org.tangdao.modules.sys.model.domain.User;
import org.tangdao.modules.sys.service.impl.PasswordEncoderService;
import org.tangdao.modules.sys.utils.LogUtils;
import org.tangdao.modules.sys.utils.UserUtils;

import eu.bitwalker.useragentutils.UserAgent;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Configuration
	@Order(1)                                                        
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/api/**")                               
				.authorizeRequests()
					.anyRequest().hasRole("APP")
					.and()
				.httpBasic();
		}
	}
    
    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    	
    	@Value("${security.loginUrl}")
    	private String loginUrl;
    	
    	@Value("${security.logoutUrl}")
    	private String logoutUrl;
    	
    	@Value("${security.successUrl}")
    	private String successUrl;
    	
    	@Value("${security.authorizeUrl}")
    	private String authorizeUrl;
    	
    	private final UserDetailsService userDetailsService;
    	
    	private final PasswordEncoderService passwordEncoderService;
    	
    	@Autowired
    	private RedisOperations<String, Serializable> sessionRedisOperations;
    	
        @Autowired
        public FormLoginWebSecurityConfigurerAdapter(@Qualifier("userServiceImpl") UserDetailsService userDetailsService, PasswordEncoderService passwordEncoderService) {
            this.userDetailsService = userDetailsService;
            this.passwordEncoderService = passwordEncoderService;
        }

    	@Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoderService);
        }
    	
    	@Override
        public void configure(WebSecurity web) {
            web
            	.ignoring()
            		.antMatchers("/static/**", "/webjars/**", "/v2/**", "/swagger**");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
        	
        	http.headers().frameOptions().disable();
            http
                    .csrf()
                    .disable()
                    .authorizeRequests()
                    .antMatchers(authorizeUrl).authenticated()
            .and().formLogin()
                    .loginPage(loginUrl).permitAll()
                    .successHandler(new SimpleUrlAuthenticationSuccessHandler() {
						@Override
						public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
								Authentication authentication) throws IOException, ServletException {
							// TODO Auto-generated method stub
							User user = UserUtils.getUser();
							//权限和菜单信息
							user.setMenus(UserUtils.getMenuByParentCode(null));
							
						    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(  
						    		user, authentication.getCredentials(), user.getAuthorities());  
						    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  					    
							SecurityContextHolder.getContext().setAuthentication(authenticationToken);
							
							// 记录用户登录日志
							LogUtils.saveLog(user, request, "系统登录", Log.TYPE_LOGIN_LOGOUT);
							
							request.getSession().setAttribute("host", IpUtils.getRemoteAddr(request));
							UserAgent userAgent = UserAgentUtils.getUserAgent(request);
							request.getSession().setAttribute("deviceName", userAgent.getOperatingSystem().getName());
							super.setAlwaysUseDefaultTargetUrl(true);
							super.setDefaultTargetUrl(successUrl);
//							super.setUseReferer(true);
							super.onAuthenticationSuccess(request, response, authentication);
						}
					})
                    .failureUrl(loginUrl+"?error=true")
            .and().logout()
            		.logoutUrl(logoutUrl).permitAll()
             		.logoutSuccessHandler(new SimpleUrlLogoutSuccessHandler() {
             			public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
             					Authentication authentication) throws IOException, ServletException {
         					if (authentication != null && authentication.getPrincipal() != null) {
         						LogUtils.saveLog((User)authentication.getPrincipal(), request, "系统退出", Log.TYPE_LOGIN_LOGOUT);
         					}
         					//清楚用户相关所有session信息
         					cleanRedisSession(request, authentication);
         					
         					super.setAlwaysUseDefaultTargetUrl(true);
             				super.setDefaultTargetUrl(loginUrl+"?logout");
//             				super.setUseReferer(true);
             				super.onLogoutSuccess(request, response, authentication);
             			}
					});
            http
            	.sessionManagement()
                 // 无效session跳转
            	.invalidSessionUrl(loginUrl)
            	.maximumSessions(1)
                 // session过期跳转
            	.expiredUrl(loginUrl+"?expired=true")
            	.sessionRegistry(sessionRegistry());
        }
        
        /**
         * 解决session失效后 sessionRegistry中session没有同步失效的问题，启用并发session控制，首先需要在配置中增加下面监听器
         * @return
         */
        @Bean
        public HttpSessionEventPublisher httpSessionEventPublisher() {
            return new HttpSessionEventPublisher();
        }
        
        @Lazy
        @Autowired
        public RedisOperationsSessionRepository sessionRepository;
        
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Bean
        public SpringSessionBackedSessionRegistry<Session> sessionRegistry() {
        	return new SpringSessionBackedSessionRegistry(sessionRepository);
        }
		
		/**
		 * 
		 * @param request
		 * @param authentication
		 */
		private void cleanRedisSession(HttpServletRequest request, Authentication authentication) {
			//清楚全部当前用户session信息
			String sessionId = request.getSession().getId();
			sessionRedisOperations.boundValueOps("spring:session:sessions:"+sessionId).expire(0, TimeUnit.SECONDS);
			sessionRedisOperations.boundValueOps("spring:session:sessions:expires:"+sessionId).expire(0, TimeUnit.SECONDS);
			String key = RedisOperationsSessionRepository.DEFAULT_NAMESPACE + ":index:"+ RedisOperationsSessionRepository.PRINCIPAL_NAME_INDEX_NAME;
			sessionRedisOperations.boundValueOps(key+":" + name(authentication.getPrincipal())).expire(0, TimeUnit.SECONDS);
		}
		
		private String name(Object principal) {
			if (principal instanceof UserDetails) {
				return ((UserDetails) principal).getUsername();
			}
			if (principal instanceof Principal) {
				return ((Principal) principal).getName();
			}
			return principal.toString();
		}
		
	}

}
