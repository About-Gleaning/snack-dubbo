package com.liurui.base.sys.enums;

public enum LoginFlag {
    ALLOW(1, "允许"), NOT_ALLOW(0, "禁止");

    private Integer val;
    private String msg;

    LoginFlag(Integer val, String msg) {
        this.val = val;
        this.msg = msg;
    }

    public Integer getVal() {
        return val;
    }

    public String getMsg() {
        return msg;
    }
}
