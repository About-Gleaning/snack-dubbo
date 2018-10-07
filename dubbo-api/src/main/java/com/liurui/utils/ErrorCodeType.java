package com.liurui.utils;

/**
 * @Author liurui
 * @Description 错误代码枚举类
 * @Date 上午8:46 2018/10/7
 **/
public enum ErrorCodeType {
    SUCCESS(0), //成功
    SYSTEM_ERROR(100),    //系统异常
    DATABASE_ERROR(200);  //数据库异常

    private Integer value;

    ErrorCodeType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
