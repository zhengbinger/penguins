package com.penguins.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;

/**
 * Mybatis 配置类
 *
 * @author 郑冰
 * @date 2022/5/9 11:52
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class MyBatisConfig {


//    @Bean
//    public HandlerCommonInterceptor interceptor() {
//        return new HandlerCommonInterceptor();
//    }


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

}
