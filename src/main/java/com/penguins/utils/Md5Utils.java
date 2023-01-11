package com.penguins.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/10 08:47
 **/
public class Md5Utils {

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5Hex("chian"));
    }
}

