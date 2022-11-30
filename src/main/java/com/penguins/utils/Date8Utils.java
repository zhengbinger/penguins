package com.penguins.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/11/30 10:57
 **/
public final class Date8Utils {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalTime time() {
        return LocalTime.now();
    }

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalDateTime date2Time(Date date) {
        return null;
    }

    public static Date convertLocalDateTime2Date() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Date8Utils.now());
        System.out.println(Date8Utils.today());
    }
}
