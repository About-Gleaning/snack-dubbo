package com.liurui.sys.user.controller;


import com.liurui.base.BaseController;
import com.liurui.common.enums.ErrorCodeType;
import com.liurui.common.module.ResultBean;
import com.liurui.sys.user.entity.User;
import com.liurui.sys.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liurui
 * @since 2019-04-03
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/getByAccount")
    public ResultBean getByAccount(String account) {
        ResultBean resultBean = ResultBean.getInstance();
        User user = userService.getByAccount(account);
        resultBean.setData(user);
        return resultBean;
    }

    @RequestMapping("/save")
    public ResultBean save(User user) {
        ResultBean resultBean = null;
        if (!User.vailData(user)) {
            resultBean = ResultBean.getInstance();
            resultBean.setErrorCode(ErrorCodeType.MISSING_PASSWORD);
            resultBean.setMessage("缺少参数");
            return resultBean;
        }
        return userService.saveUser(user);
    }

}
