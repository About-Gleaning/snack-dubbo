package com.liurui.base.sys.service.impl;

import com.liurui.base.sys.entity.SysRolePermission;
import com.liurui.base.sys.mapper.SysRolePermissionMapper;
import com.liurui.base.sys.service.ISysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户权限表 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2018-10-25
 */
@Service(value = "com.liurui.base.sys.service.impl.SysRolePermissionServiceImpl")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements ISysRolePermissionService {

}
