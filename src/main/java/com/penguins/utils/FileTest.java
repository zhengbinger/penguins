package com.penguins.utils;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/9/13 09:59
 **/
public class FileTest {

    public static void main(String[] args) {
//        File file = new File("/Users/zhengbing/Desktop/settings.xml");
//        try {
//            int length = 1024;
//            byte[] bytes = new byte[length];
//            FileInputStream inputStream = new FileInputStream(file);
//            while (inputStream.read(bytes) != -1) {
//                System.out.println(new String(bytes));
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        String str = "http://101.33.240.92:9000/wms/app/2022/35/17/05adfde3-3d9c-459c-94ca-6193f8bac0b7/github.md";
        System.out.println(str.substring(str.lastIndexOf("app")));
    }
}
