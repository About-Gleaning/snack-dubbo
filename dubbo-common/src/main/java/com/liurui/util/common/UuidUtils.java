package com.liurui.util.common;

import java.util.UUID;

/**
 * @ClassName UuidUtils
 * @Description 生成32位随机数
 * @Author liurui
 * @Date 2018/10/7 上午8:01
 **/
public class UuidUtils {

    //Suppress default constructor for noninstantiability
    private UuidUtils() {
        throw new AssertionError();
    }

    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        System.out.println(a + " \n " + b);
        System.exit(0);
    }
}
