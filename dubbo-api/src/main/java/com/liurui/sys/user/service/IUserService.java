package com.liurui.sys.user.service;

import com.liurui.sys.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author liurui
 * @since 2019-04-03
 */
public interface IUserService extends IService<User> {

    User getByAccount(String account);

    int saveUser(User user);
}
