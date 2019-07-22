package org.tangdao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.tangdao.modules.sys.service.impl.PasswordEncoderService;

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
    @EnableGlobalMethodSecurity(prePostEnabled = true)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    	
    	private final UserDetailsService userDetailsService;
    	
    	private final PasswordEncoderService passwordEncoderService;

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
        protected void configure(HttpSecurity http) throws Exception {
        	http.headers().frameOptions().disable();
            http
                    .csrf()
                    .disable()
                    .authorizeRequests()
//                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                    .antMatchers("/app/**","/media/**","/theme/**","/vendors/**").permitAll()
//                    .anyRequest().authenticated()
                    .antMatchers("/**").permitAll()
            .and().formLogin()
                    .loginPage("/login").permitAll()
                    .failureUrl("/login?error=true")
                    .and()
                    .userDetailsService(this.userDetailsService);
                    

        }
	}

}
