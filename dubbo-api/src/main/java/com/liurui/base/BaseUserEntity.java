package com.liurui.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName BaseUserEntity
 * @Description TODO
 * @Author liurui
 * @Date 2019/4/19 11:23 AM
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BaseUserEntity extends BaseEntity{

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

}
