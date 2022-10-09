package com.penguins.component.redis;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义缓存键生成策略，主要用于@Cacheable 等 Spring 缓存类注解使用时，
 * 拼接后缀，从而不自动拼接不可控的后缀
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/8/4 23:31
 **/
@Component
public class PenguinsKeyGenerator implements KeyGenerator {

    @NotNull
    @Override
    public Object generate(@NotNull Object target, @NotNull Method method, @NotNull Object... params) {
        return "penguins";
    }
}
