package com.liurui.base.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurui.base.sys.entity.SysUser;
import com.liurui.base.sys.mapper.SysUserMapper;
import com.liurui.base.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
@Service(value = "com.liurui.base.sys.service.impl.SysUserServiceImpl")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> getList() {
        return this.list(new QueryWrapper<>());
    }

    @Override
    public SysUser getByAccount(String account) {
        return super.getOne(new QueryWrapper<SysUser>().eq("account", account));
    }

}
