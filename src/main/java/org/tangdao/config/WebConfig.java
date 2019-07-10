package org.tangdao.config;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.tangdao.common.beetl.BeetlConfiguration;
import org.tangdao.common.beetl.BeetlViewResolver;
import org.tangdao.common.utils.JsonMapper;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Value("${beetl.templatesPath}") String templatesPath;
	@Bean(name = "beetlConfig")
	public BeetlConfiguration beetlConfiguration() {
		BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			loader = BeetlConfiguration.class.getClassLoader();
		}
//		beetlConfiguration.setConfigProperties(extProperties);//额外的配置，可以覆盖默认配置，一般不需要
		ClasspathResourceLoader classpath = new ClasspathResourceLoader(loader, templatesPath);
		beetlConfiguration.setResourceLoader(classpath);
		beetlConfiguration.init();
		//如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
		beetlConfiguration.getGroupTemplate().setClassLoader(loader);
		return beetlConfiguration;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		BeetlViewResolver beetlViewResolver = new BeetlViewResolver();
		beetlViewResolver.setContentType("text/html;charset=UTF-8");
		beetlViewResolver.setOrder(0);
		beetlViewResolver.setConfig(beetlConfiguration());
		beetlViewResolver.setSuffix(".html");
		registry.viewResolver(beetlViewResolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		ResourceHandlerRegistration resource = registry.addResourceHandler("/static/**");
		resource.addResourceLocations("/static/", "classpath:/static/");
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		return new JsonMapper();
	}
	
	@Bean
	@ConditionalOnMissingBean
	public HttpMessageConverter<Object> httpMessageConverter() {
		return new MappingJackson2HttpMessageConverter(this.objectMapper());
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
		converters.add(stringConverter);
		converters.add(httpMessageConverter());
	}
	
	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new ErrorPageRegistrar() {
			public void registerErrorPages(ErrorPageRegistry e) {
				ErrorPage badRequest = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
				ErrorPage unauthorized = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/403");
				ErrorPage forbidden = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403");
				ErrorPage notFound = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
				ErrorPage internalServerError = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
				ErrorPage throwable = new ErrorPage(Throwable.class, "/error/500");
				e.addErrorPages(badRequest, unauthorized, forbidden, notFound, internalServerError, throwable);
			}
		};
	}
}
