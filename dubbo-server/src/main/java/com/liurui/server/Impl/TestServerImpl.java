package com.liurui.server.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liurui.server.TestServer;
import org.springframework.stereotype.Component;

/**
 * @ClassName TestServerImpl
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:30
 **/
@Service(interfaceClass = TestServer.class)
@Component
public class TestServerImpl implements TestServer {
    @Override
    public String sayHello(String str) {
        return "say hello " + str + "from dubbo-server";
    }
}
