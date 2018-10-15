package com.liurui.util.common;

import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @ClassName ConvertUtils
 * @Description 转换类
 * @Author liurui
 * @Date 2018/10/12 下午5:31
 **/
public class ConvertUtils {

    /**
     * 对象转map
     * @param obj
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Map<String, Object> map = Maps.newHashMap();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                map.put(field.getName(), field.get(obj));

            }
            return map;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    /**
     * map转对象`
     * @param map
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T map2Object(Map<String, Object> map, Class<T> beanClass) {
        if (map == null) {
            return null;
        }
        try {
            Object obj = beanClass.newInstance();
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                int modifier = field.getModifiers();
                if (Modifier.isStatic(modifier) || Modifier.isFinal(modifier)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
            return (T) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
