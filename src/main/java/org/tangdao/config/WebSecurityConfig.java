package org.tangdao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.tangdao.modules.sys.service.impl.PasswordEncoderService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	
	private final PasswordEncoderService passwordEncoderService;

    @Autowired
    public WebSecurityConfig(@Qualifier("userServiceImpl") UserDetailsService userDetailsService, PasswordEncoderService passwordEncoderService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoderService = passwordEncoderService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoderService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/api/**").permitAll()
        .and().formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=true")
                .and()
                .userDetailsService(this.userDetailsService);

    }
}
