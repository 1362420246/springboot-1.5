package com.qbk.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * Swagger2 配置
 * Spring中的@Profile注解，可以实现不同环境（开发、测试、部署等）使用不同的配置。可以多个
 */
@Profile({ "dev"})
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Swagger api docket
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
                useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.qbk.controller"))
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build().apiInfo(apiInfo())
//权限配置 https://www.jianshu.com/p/6e5ee9dd5a61
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                ;

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("页面标题")
                .description("描述")
                .version("1.0")
                .build();
    }

    //权限配置
    private List<ApiKey> securitySchemes() {
        return Lists.newArrayList(new ApiKey("Authorization", "Authorization", "header"));
    }
    //权限配置
    private List<SecurityContext> securityContexts() {
        return Lists.newArrayList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build());
    }
    //权限配置
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }
}
