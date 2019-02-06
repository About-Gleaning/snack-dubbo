package com.liurui.shiro;

import com.liurui.base.sys.entity.SysUser;
import com.liurui.base.sys.enums.LoginFlag;
import com.liurui.base.sys.service.ISysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * @ClassName SnackRealm
 * @Description 自定义Realm
 * @Author liurui
 * @Date 2018/10/16 下午3:14
 **/
public class SysRealm extends AuthorizingRealm {

    @Resource
    private ISysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 验证用户身份，登陆时调用
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取账号
//        UsernamePasswordToken
        String account = String.valueOf(authenticationToken.getPrincipal());
        //获取账号对象SysUser
        SysUser user = sysUserService.getByAccount(account);
        if (null == user) {
            throw new AccountException("用户名不存在");
        }
        if (user.getLoginFlag().equals(LoginFlag.NOT_ALLOW.getVal())) {
            throw new AccountException("禁止登陆");
        }
        if (!user.getPassword().equals(new String((char[]) authenticationToken.getCredentials()))) {
            throw new AccountException("密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getAccount(),
                user.getPassword(),
                user.getNickName());
        return authenticationInfo;
    }

}
