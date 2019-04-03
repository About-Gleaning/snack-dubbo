package com.liurui.sys.user.service.impl;

import com.liurui.sys.user.entity.User;
import com.liurui.sys.user.mapper.UserMapper;
import com.liurui.sys.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2019-04-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getByAccount(String account) {
        return null;
    }
}
