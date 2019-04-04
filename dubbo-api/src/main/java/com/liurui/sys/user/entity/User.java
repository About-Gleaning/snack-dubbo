package com.liurui.sys.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liurui.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author liurui
 * @since 2019-04-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 性别。0未知，1男，2女
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * 住址
     */
    private String address;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 登陆标识。0禁止，1允许
     */
    private Integer loginFlag;

    public static boolean vailData(User user) {
        boolean flag = true;
        if (StringUtils.isBlank(user.getAccount()))
            flag = false;
        if (StringUtils.isBlank(user.getPassword()))
            flag = false;
        return flag;
    }

}
