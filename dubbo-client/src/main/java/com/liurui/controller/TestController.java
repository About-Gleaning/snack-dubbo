package com.liurui.controller;

import com.liurui.entity.UserInfo;
import com.liurui.server.TestServer;
import com.liurui.utils.ErrorCodeType;
import com.liurui.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TestServer testServer;

    @RequestMapping(value = "sayHello")
    public String sayHello(@RequestParam String str) {
        return testServer.sayHello(str);
    }

    @RequestMapping(value = "/addUser")
    public ResultBean addUser(@RequestParam UserInfo userInfo) {
        ResultBean result = new ResultBean(ErrorCodeType.DATABASE_ERROR, "保存用户信息失败", null);
        try {
            int count = testServer.saveUserInfo(userInfo);
            result.setErrorInfo(ErrorCodeType.SUCCESS, "保存用户信息成功", null);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

    @RequestMapping(value = "/addUser2")
    public ResultBean addUser2(@RequestParam String name, @RequestParam String phone, @RequestParam Integer sex, @RequestParam Integer age) {
        ResultBean result = new ResultBean(ErrorCodeType.DATABASE_ERROR, "保存用户信息失败", null);
        try {
            UserInfo userInfo = new UserInfo(name, phone, sex, age);
            int count = testServer.saveUserInfo(userInfo);
            result.setErrorInfo(ErrorCodeType.SUCCESS, "保存用户信息成功", null);
            return result;
        } catch (Exception e) {
            return result;
        }
    }

}
