package com.liurui.base.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurui.base.sys.entity.SysUserRole;
import com.liurui.base.sys.mapper.SysUserRoleMapper;
import com.liurui.base.sys.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
@Service(value = "com.liurui.base.sys.service.impl.SysUserRoleServiceImpl")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
