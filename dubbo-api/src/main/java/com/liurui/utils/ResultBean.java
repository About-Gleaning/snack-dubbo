package com.liurui.utils;

import java.io.Serializable;

/**
 * @ClassName ResultBean
 * @Description 返回结果bean
 * @Author liurui
 * @Date 2018/10/7 上午8:38
 **/
public class ResultBean implements Serializable {

    private ErrorCodeType errorCode;

    private String message;

    private Object data;

    public ResultBean(ErrorCodeType errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public void setErrorInfo(ErrorCodeType errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

}
