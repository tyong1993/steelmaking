package com.steel.application.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 买家端
     * @param environment
     * @return
     */
    @Bean
    public Docket buyUser(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test","pro");
        boolean enable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A买家端")
                //是否启用,如果想生产环境不启用则根据环境变量控制
                .enable(enable)
                //文档信息
                .apiInfo(apiInfo())
                //配置接口扫描
                .select()
                //基于注解扫描
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //基于包扫描
//                .apis(RequestHandlerSelectors.basePackage("com.steel.application.controller"))
                //请求路径过滤
                .paths(PathSelectors.any())
                .build();

    }
    /**
     * 卖家端
     * @param environment
     * @return
     */
    @Bean
    public Docket saleUser(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test","pro");
        boolean enable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("B业务员端")
                //是否启用,如果想生产环境不启用则根据环境变量控制
                .enable(enable)
                //文档信息
                .apiInfo(apiInfo())
                //配置接口扫描
                .select()
                //基于注解扫描
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //基于包扫描
//                .apis(RequestHandlerSelectors.basePackage("com.steel.application.controller"))
                //请求路径过滤
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SteelMaking Doc")
                .description("......")
                .version("1.0")
//                .contact(new Contact("tyong","","1160282242@qq.com"))
                .build();
    }

}