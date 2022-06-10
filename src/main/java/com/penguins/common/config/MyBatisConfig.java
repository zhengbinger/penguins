package com.penguins.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Mybatis 拦截器配置类
 *
 * @author 郑冰
 * @date 2022/5/9 11:52
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class MyBatisConfig {

    /**
     * 添加分页插件
     *
     * @return MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 添加Mybatis 公共拦截器
     *
     * @return MybatisCommonInterceptor
     */
//    @Bean
//    public MybatisCommonInterceptor interceptor() {
//        return new MybatisCommonInterceptor();
//    }


}
