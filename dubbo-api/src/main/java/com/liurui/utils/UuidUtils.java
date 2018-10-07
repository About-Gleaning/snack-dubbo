package com.liurui.utils;

import java.util.UUID;

/**
 * @ClassName UuidUtils
 * @Description 生成32位随机数
 * @Author liurui
 * @Date 2018/10/7 上午8:01
 **/
public class UuidUtils {

    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
}
