package com.liurui.util.common;

import com.google.common.collect.Maps;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ConvertUtils
 * @Description 转换类
 * @Author liurui
 * @Date 2018/10/12 下午5:31
 **/
public class ConvertUtils {

    //Suppress default constructor for noninstantiability
    private ConvertUtils() {
        throw new AssertionError();
    }

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
                Method method = obj.getClass().getMethod("get" + StringUtils.firstCharToUpperCase(field.getName()));
                Object value = method.invoke(obj);
                map.put(field.getName(), value);
            }
            return map;
        } catch (IllegalAccessException e) {
            return null;
        } catch (NoSuchMethodException e) {
            return null;
        } catch (InvocationTargetException e) {
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


    /**
     * 对象转对象
     * @param source
     * @param target
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T obj2Obj(Object source, Class<T> target) throws Exception {
        if (null == source || null == target) {
            throw new NullPointerException();
        }
        try {
            Object obj = target.newInstance();
            Field[] fields = target.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers()) || "ids".equals(field.getName())) {
                    continue;
                }
                String getMethodName = "get" + StringUtils.firstCharToUpperCase(field.getName());
                String setMethodName = "set" + StringUtils.firstCharToUpperCase(field.getName());
                try {
                    Method getMethod = source.getClass().getMethod(getMethodName);
                    Object data = getMethod.invoke(source);
                    Type type = field.getGenericType();
                    String a = type.toString();
                    String b = a.replace("class ", "");
                    Class.forName(b);
                    Method setMethod = target.getMethod(setMethodName, Class.forName(type.toString().replace("class ", "")));
                    setMethod.invoke(obj, data);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            return (T) obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new InstantiationException();
        }
    }

}
