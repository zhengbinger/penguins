package com.penguins.common.pattern.factorys.simple;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/7/6 11:15
 **/
public class Test {

    public static void main(String[] args) {
        IProduct product = SimpleFactory.getBean("first");
        System.out.println(product);
    }
}
