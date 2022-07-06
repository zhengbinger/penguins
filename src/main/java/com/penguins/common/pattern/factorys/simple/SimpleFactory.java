package com.penguins.common.pattern.factorys.simple;

/**
 * 简单工厂获取实例
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/7/6 11:04
 **/
public class SimpleFactory {

    private static final String FIRST_FACTORY_NAME = "first";
    private static final String SECOND_FACTORY_NAME = "second";

    public static IProduct getBean(String param) {
        if (FIRST_FACTORY_NAME.equals(param)) {
            return new FirstProduct();
        } else if (SECOND_FACTORY_NAME.equals(param)) {
            return new SecondProduct();
        } else {
            return null;
        }
    }
}
