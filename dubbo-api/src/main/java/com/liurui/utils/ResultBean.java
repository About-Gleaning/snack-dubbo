package com.liurui.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName ResultBean
 * @Description 返回结果bean
 * @Author liurui
 * @Date 2018/10/7 上午8:38
 **/
@Data
public class ResultBean implements Serializable {

    private ErrorCodeType errorCode;

    private String message;

    private Object data;

    private ResultBean() {
        this.errorCode = ErrorCodeType.SUCCESS;
    }

    private ResultBean(ErrorCodeType errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public static ResultBean getInstance() {
        return new ResultBean();
    }

    public static ResultBean getInstance(ErrorCodeType errorCode, String message, Object data) {
        return new ResultBean(errorCode, message, data);
    }

    public void setErrorInfo(ErrorCodeType errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public ErrorCodeType getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeType errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
