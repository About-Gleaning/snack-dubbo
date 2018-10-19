package com.liurui.base.sys.controller;


import com.liurui.base.sys.entity.SysUser;
import com.liurui.base.sys.service.ISysUserService;
import com.liurui.utils.ErrorCodeType;
import com.liurui.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.liurui.base.BaseController;

import java.util.List;

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
    public ResultBean getList() {
        List<SysUser> list = sysUserService.getList();
        return new ResultBean(ErrorCodeType.SUCCESS, "SUCCESS", list);
    }

    @RequestMapping(value = "/getById")
    public ResultBean getById(@RequestParam String id) {
        return new ResultBean(ErrorCodeType.SUCCESS, "SUCCESS", sysUserService.getById(id));
    }

    @RequestMapping(value = "/addUser")
    public ResultBean addUser(@RequestParam SysUser sysUser) {
        return new ResultBean(ErrorCodeType.SUCCESS, "SUCCESS", sysUserService.save(sysUser));
    }

}
