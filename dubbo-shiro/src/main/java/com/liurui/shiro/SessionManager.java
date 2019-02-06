package com.liurui.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * @ClassName SessionManager
 * @Description 一般都是cookie中获取sessionId，这里重写获取session的方式为从ajax请求头中获取
 * @Author liurui
 * @Date 2018/10/19 下午3:31
 **/
//public class SessionManager extends DefaultWebSessionManager {
//
//    private static final String AUTHORIZATION = "Authorization";
//
//    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
//
//    @Override
//    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
//    }
//}
