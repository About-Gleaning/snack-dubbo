package com.liurui.utils.enums;

/**
 * 删除
 */
public enum DelFlag {
    YES(1, "是"), NO(0, "否");

    private Integer val;

    private String msg;

    DelFlag(Integer val, String msg) {
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
