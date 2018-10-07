package com.liurui.entity;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private String id;

    private String name;

    private String phone;

    private Integer sex;

    private Integer age;

    public UserInfo(String name, String phone, Integer sex, Integer age) {
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.age = age;
    }

    public UserInfo() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}