package com.liurui.common.enums;

/**
 * 删除
 */
public enum LoginFlag {
    ALLOW(1), NOT_ALLOW(0);

    private Integer val;

    LoginFlag(Integer val) {
        this.val = val;
    }

    public Integer getVal() {
        return val;
    }

}
