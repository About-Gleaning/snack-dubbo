package com.liurui.sys.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liurui.common.enums.ErrorCodeType;
import com.liurui.common.module.ResultBean;
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
    public ResultBean saveUser(User user) {
        ResultBean resultBean = ResultBean.getInstance(ErrorCodeType.FAILED, null, null);
        if (null == this.getByAccount(user.getAccount())) {
            if (this.save(user)) {
                resultBean.setErrorCode(ErrorCodeType.SUCCESS);
                return resultBean;
            }
            resultBean.setMessage("保存失败");
            return resultBean;
        }
        resultBean.setMessage("帐号已存在");
        return resultBean;
    }
}
