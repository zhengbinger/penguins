package com.penguins.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/9/13 09:59
 **/
public class FileTest {

    public static void main(String[] args) {
        File file = new File("/Users/zhengbing/Desktop/settings.xml");
        try {
            int length = 1024;
            byte[] bytes = new byte[length];
            FileInputStream inputStream = new FileInputStream(file);
            while (inputStream.read(bytes) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
