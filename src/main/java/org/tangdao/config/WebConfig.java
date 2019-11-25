package org.tangdao.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.AccessExpressionIfFunction;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.tangdao.common.beetl.BeetlConfiguration;
import org.tangdao.common.beetl.BeetlViewResolver;
import org.tangdao.common.config.Global;
import org.tangdao.common.utils.PropertiesUtils;
import org.tangdao.common.utils.SpringUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.sys.interceptor.LogInterceptor;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;


@Configuration
@AutoConfigureBefore({ValidationAutoConfiguration.class, MultipartAutoConfiguration.class})
@EnableWebMvc
@EnableConfigurationProperties({MultipartProperties.class})
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public AccessExpressionIfFunction accessExpressionIfFunction() {
		return new AccessExpressionIfFunction();
	}

	@Value("${beetl.templatesPath}") String templatesPath;
	@Bean(name = "beetlConfig")
	public BeetlConfiguration beetlConfiguration() {
		BeetlConfiguration beetlConfiguration = new BeetlConfiguration(accessExpressionIfFunction());
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
		registry.addResourceHandler("/static/**").addResourceLocations("/static/", "classpath:/static/");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Bean
	@Primary
	public LocalValidatorFactoryBean beanValidator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
		return localValidatorFactoryBean;
	}

	@Bean
	public MethodValidationPostProcessor getMethodValidationPostProcessor() {
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		processor.setValidator(beanValidator());
		return processor;
	}

	@Override
	public Validator getValidator() {
		return this.beanValidator();
	}
	
	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new ErrorPageRegistrar() {
			public void registerErrorPages(ErrorPageRegistry e) {
				ErrorPage badRequest = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
				ErrorPage unauthorized = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401");
				ErrorPage forbidden = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403");
				ErrorPage notFound = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
				ErrorPage methodNotAllowed = new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error/405");
				ErrorPage internalServerError = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
				ErrorPage throwable = new ErrorPage(Throwable.class, "/error/500");
				e.addErrorPages(badRequest, unauthorized, forbidden, notFound, methodNotAllowed, internalServerError, throwable);
			}
		};
	}
	
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

	@Bean
	@Lazy(false)
	@ConditionalOnMissingBean
	public SpringUtils springUtils() {
		return new SpringUtils();
	}
	
	@Configuration
	@ConditionalOnProperty(name="web.interceptor.log.enabled", havingValue="true", matchIfMissing=true)
	public static class LogInterceptorWebMvcConfigurer implements WebMvcConfigurer {
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			InterceptorRegistration registration = registry.addInterceptor(new LogInterceptor());
			String apps = Global.getConfig("web.interceptor.log.addPathPatterns");
			String epps = Global.getConfig("web.interceptor.log.excludePathPatterns");
			for (String uri : StringUtils.split(apps, ",")){
				if (StringUtils.isNotBlank(uri)){
					registration.addPathPatterns(StringUtils.trim(uri));
				}
			}
			for (String uri : StringUtils.split(epps, ",")){
				if (StringUtils.isNotBlank(uri)){
					registration.excludePathPatterns(StringUtils.trim(uri));
				}
			}
		}
	}
	
}
