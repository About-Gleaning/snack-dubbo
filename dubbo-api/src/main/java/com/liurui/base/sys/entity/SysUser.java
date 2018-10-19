package com.liurui.base.sys.entity;

import com.liurui.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 部门id
     */
    private String departmentId;

    /**
     * 职位id
     */
    private String positionId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮件
     */
    private String email;

    /**
     * 头像
     */
    private String photo;

    /**
     * 状态
     */
    private String state;

    /**
     * 最近登陆的ip
     */
    private String lastIp;

    /**
     * 最近登陆的时间
     */
    private LocalDateTime lastTime;

    /**
     * 是否可登陆
     */
    private String loginFlag;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标示
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 扩展1
     */
    private String expand1;

    /**
     * 扩展2
     */
    private String expand2;

    /**
     * 扩展3
     */
    private String expand3;

    /**
     * 扩展4
     */
    private String expand4;


}
