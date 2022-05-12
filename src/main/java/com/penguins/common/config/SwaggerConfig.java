package com.penguins.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger 配置类
 *
 * @author 郑冰
 * @date 2022/4/5 13:32
 * @email mydreambing@126.com
 * @since jdk8
 **/
@EnableKnife4j
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
                .apis(RequestHandlerSelectors.basePackage("com.penguins.controller"))
                .paths(PathSelectors.any())
                .build().groupName("管理后台");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("管理后台")
                // 设置接口描述
                .description("管理后台API")
                // 设置联系方式
                .contact(new Contact("ZhengBing", null, "mydreambing@126.com"))
                // 设置版本
                .version("1.0")
                .build();
    }
}
