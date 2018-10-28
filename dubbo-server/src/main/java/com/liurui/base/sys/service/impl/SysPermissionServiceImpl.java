package com.liurui.base.sys.service.impl;

import com.liurui.base.sys.entity.SysPermission;
import com.liurui.base.sys.mapper.SysPermissionMapper;
import com.liurui.base.sys.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2018-10-25
 */
@Service(value = "com.liurui.base.sys.service.impl.SysPermissionServiceImpl")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

}
