package com.liurui.sys.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurui.sys.user.entity.User;
import com.liurui.sys.user.mapper.UserMapper;
import com.liurui.sys.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liurui
 * @since 2019-04-03
 */
@Service("com.liurui.sys.user.service.impl.UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    //帐号已存在
    private static final int ACCOUNT_EXISTS = 1;

    /**
     * 通过account查询用户
     * @param account
     * @return
     */
    @Override
    public User getByAccount(String account) {
        QueryWrapper wrapper = new QueryWrapper<User>();
        wrapper.eq("account", account);
        return baseMapper.selectOne(wrapper);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
        if (null == this.getByAccount(user.getAccount())) {
            if (this.save(user)) {
            }
        }
        return 1;
    }
}
