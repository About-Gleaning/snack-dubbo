package com.liurui.utils;

import java.lang.reflect.Method;
import java.util.EnumSet;

/**
 * @ClassName EnumUtils
 * @Description 枚举工具类
 * @Author liurui
 * @Date 2018/10/19 下午4:16
 **/
public class EnumUtils {

    /**
     * 字符取值
     * @param target
     * @param msg
     * @param <T>
     * @return
     */
    public static <T extends Enum> Integer getValByMsg(Class<T> target, String msg) {
        try {
            Method method = target.getDeclaredMethod("values");
            Object value = method.invoke(target);
            T[] enums = (T[]) value;
            for (T t : enums) {
                method = t.getClass().getDeclaredMethod("getMsg");
                if (msg.equals(String.valueOf(method.invoke(t)))) {
                    method = t.getClass().getDeclaredMethod("getVal");
                    return Integer.parseInt(String.valueOf(method.invoke(t)));
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

}
