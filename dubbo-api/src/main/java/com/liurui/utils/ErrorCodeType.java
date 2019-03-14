package com.liurui.utils;

/**
 * @Author liurui
 * @Description 错误代码枚举类
 * @Date 上午8:46 2018/10/7
 **/
public enum ErrorCodeType {
    //成功
    SUCCESS(0),
    //系统异常
    SYSTEM_ERROR(100),
    //数据库异常
    DATABASE_ERROR(200);

    private Integer value;

    ErrorCodeType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
