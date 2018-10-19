package com.liurui.base.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurui.base.sys.entity.SysRole;
import com.liurui.base.sys.mapper.SysRoleMapper;
import com.liurui.base.sys.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
@Service("com.liurui.base.sys.service.impl.SysRoleServiceImpl")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private RedisTemplate redisTemplate;
}
