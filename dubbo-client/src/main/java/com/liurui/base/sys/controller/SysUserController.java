package com.liurui.base.sys.controller;


import com.liurui.base.BaseController;
import com.liurui.base.sys.entity.SysUser;
import com.liurui.base.sys.service.ISysUserService;
import com.liurui.utils.ErrorCodeType;
import com.liurui.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liurui
 * @since 2018-10-18
 */
@RestController
@RequestMapping("/base/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "/getList")
    public ResultBean getList(HttpServletRequest request) {
        System.out.println("thread " + Thread.currentThread().getName() + " start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        List<SysUser> list = sysUserService.getList();
        System.out.println("thread " + Thread.currentThread().getName() + " end");
        return new ResultBean(ErrorCodeType.SUCCESS, "SUCCESS", null);
    }

    @RequestMapping(value = "/getById")
    public ResultBean getById(@RequestParam String id) {
        return new ResultBean(ErrorCodeType.SUCCESS, "SUCCESS", sysUserService.getById(id));
    }

    @RequestMapping(value = "/addUser")
    public ResultBean addUser(@RequestBody SysUser sysUser) {
        return new ResultBean(ErrorCodeType.SUCCESS, "SUCCESS", sysUserService.save(sysUser));
    }

    @RequestMapping(value = "/downloadPhoto")
    public Callable<ResultBean> downloadPhoto(@RequestParam String url, HttpServletResponse response) {
        System.out.println("---main start---");

        ResultBean resultBean = new ResultBean(ErrorCodeType.SUCCESS, "success", null);
        Callable<ResultBean> callable = () -> {
            System.out.println("---childr start---");
            File file = new File(url);
//            response.setContentType();
            Thread.sleep(3000);
            System.out.println("---childr end---");
            return resultBean;
        };
        System.out.println("---main end---");
        return callable;
    }

}
