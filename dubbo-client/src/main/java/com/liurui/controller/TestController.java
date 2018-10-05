package com.liurui.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.liurui.server.TestServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:35
 **/
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private TestServer testServer;

    @RequestMapping(value = "sayHello")
    public String sayHello(@RequestParam String str) {
        return testServer.sayHello(str);
    }
}
