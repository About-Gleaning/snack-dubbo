package com.liurui.util.common;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author liurui
 * @Date 2019/2/13 2:59 PM
 **/
public class StringUtils {

    //Suppress default constructor for noninstantiability
    private StringUtils() {
        throw new AssertionError();
    }

    /**
     * 首字母大写
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母小写
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    public static void main(String[] args) {
        double a = 0.3;
        double b = 0.2;
        double c = a-b;
        System.out.println(c);
        System.exit(0);
    }

}
