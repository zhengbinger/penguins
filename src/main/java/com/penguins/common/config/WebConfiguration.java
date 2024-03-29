package com.penguins.common.config;

import com.penguins.common.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * SpringMvc 通用配置
 *
 * @author 郑冰
 * @date 2022/5/10 09:55
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").
                addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").
                addResourceLocations("classpath:/static/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/**");
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        //拦截lang参数
//        localeInterceptor.setParamName("lang");
        registry.addInterceptor(localeInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
