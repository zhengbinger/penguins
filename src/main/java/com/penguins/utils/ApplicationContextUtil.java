package com.penguins.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * Spring 容器上下文工具类
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/6 15:36
 **/
@Slf4j
@ConditionalOnBean(ApplicationContext.class)
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public ApplicationContextUtil() {
        log.info("ApplicationContextUtil init.....");
    }

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext spring上下文对象
     * @throws BeansException 抛出spring异常
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("seting ApplicationContextUtil.....");
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static void setContext(ApplicationContext applicationContext) throws BeansException {
        log.info("set Context.....");
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取对象
     *
     * @param name spring配置文件中配置的bean名或注解的名称
     * @return 一个以所给名字注册的bean的实例
     * @throws BeansException 抛出spring异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 获取类型为requiredType的对象
     *
     * @param clazz 需要获取的bean的类型
     * @return 该类型的一个在ioc容器中的bean
     * @throws BeansException 抛出spring异常
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }

    /**
     * @param clazz 需要获取的bean的类型
     * @param <T>   需要获取的bean的类型
     * @return Map<String, T>
     * @throws BeansException BeansException
     */
    public static <T> Map<String, T> getBeans(Class<T> clazz) throws BeansException {
        return applicationContext.getBeansOfType(clazz);
    }


    /**
     * 如果ioc容器中包含一个与所给名称匹配的bean定义，则返回true否则返回false
     *
     * @param name ioc容器中注册的bean名称
     * @return 存在返回true否则返回false
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }
}
