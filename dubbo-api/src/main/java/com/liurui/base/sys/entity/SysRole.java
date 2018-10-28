package com.liurui.base.sys.entity;

import com.liurui.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author liurui
 * @since 2018-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;

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

    private Integer roleType;

    private Integer dataScope;

    /**
     * 备注
     */
    private String remark;

    private Integer useable;

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
