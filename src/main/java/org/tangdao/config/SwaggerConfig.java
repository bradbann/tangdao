package org.tangdao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.tangdao.modules.developer.web"))
                .paths(PathSelectors.any())
                .build();
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("开心生活平台RESTful APIS 在线手册")
                .description("更多开心生活平台接口请查看：http://docs.kaixinsh.com/swagger.html")
                .termsOfServiceUrl("http://blog.kaixinsh.com/")
                .contact(new Contact("kxsh", "http://api.kaixinsh.com/", "service@kaixinsh.com"))
                .version("2.0.1")
                .build();
    }	
}
