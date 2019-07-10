package org.tangdao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.tangdao.common.utils.PropertiesUtils;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

@Configuration
public class BeanConfig {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer localPropertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		localPropertySourcesPlaceholderConfigurer.setProperties(PropertiesUtils.getInstance().getProperties());
		localPropertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return localPropertySourcesPlaceholderConfigurer;
	}
	
	@Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
