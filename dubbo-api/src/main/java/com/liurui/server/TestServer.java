package com.liurui.server;

import com.liurui.entity.UserInfo;

import java.util.List;

/**
 * @ClassName TestServer
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:17
 **/
public interface TestServer {
    String sayHello(String str);
    Integer saveUserInfo(UserInfo userInfo);

    List<UserInfo> getList();
}
