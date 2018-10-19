package com.liurui.base.sys.entity;

import com.liurui.base.BaseEntity;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    private String departmentId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色英文名称
     */
    private String enname;

    /**
     * 角色类型
     */
    private String roleType;

    /**
     * 数据范围
     */
    private String dataScope;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否可用
     */
    private String useable;

    /**
     * 删除标识
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
