package com.liurui.sys.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liurui.base.BaseUserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

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
public class User extends BaseUserEntity {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

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

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 删除标识
     */
    private Integer delFlag;

    public static boolean vailData(User user) {
        boolean flag = true;
        if (StringUtils.isBlank(user.getAccount()))
            flag = false;
        if (StringUtils.isBlank(user.getPassword()))
            flag = false;
        return flag;
    }

}
