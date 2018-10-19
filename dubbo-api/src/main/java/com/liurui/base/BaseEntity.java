package com.liurui.base;

import java.io.Serializable;

/**
 * @ClassName BaseEntity
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/11 上午11:33
 **/
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
