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
 * @since 2018-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

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

    private Integer sex;

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

    private Integer state;

    /**
     * 最近登陆的ip
     */
    private String lastIp;

    /**
     * 最近登陆的时间
     */
    private LocalDateTime lastTime;

    private Integer loginFlag;

    /**
     * 备注
     */
    private String remark;

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
