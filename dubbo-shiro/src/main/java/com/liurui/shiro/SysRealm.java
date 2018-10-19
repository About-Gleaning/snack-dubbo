package com.liurui.shiro;

import com.liurui.base.sys.entity.SysUser;
import com.liurui.base.sys.service.ISysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName SnackRealm
 * @Description 自定义Realm
 * @Author liurui
 * @Date 2018/10/16 下午3:14
 **/
public class SysRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }



    /**
     * 验证用户身份，登陆时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取账号
        String account = String.valueOf(authenticationToken.getPrincipal());
        //获取账号对象SysUser
        SysUser user = sysUserService.getByAccount(account);
        if (null == user) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();

        return null;
    }
}
