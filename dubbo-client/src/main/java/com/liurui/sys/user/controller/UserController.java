package com.liurui.sys.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liurui.base.BaseController;
import com.liurui.sys.user.entity.User;
import com.liurui.sys.user.service.IUserService;
import com.liurui.utils.ErrorCodeType;
import com.liurui.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    public ResultBean getByAccount() {
        ResultBean resultBean = ResultBean.getInstance();
        ObjectMapper mapper = new ObjectMapper();

        User user = userService.getByAccount("");
        try {
            String jsonStr = mapper.writeValueAsString(user);
            resultBean.setData(user);
//            return jsonStr;
        } catch (JsonProcessingException e) {
            resultBean.setErrorCode(ErrorCodeType.SYSTEM_ERROR);
        }
        return resultBean;
    }

    @RequestMapping("/save")
    public ResultBean save(User user) {
        ResultBean resultBean = ResultBean.getInstance();
        if (!User.vailData(user)) {
            resultBean.setErrorCode(ErrorCodeType.MISSING_PASSWORD);
            resultBean.setMessage("缺少参数");
            return resultBean;
        }
        boolean result = userService.saveUser(user);
        if (result) {
            return resultBean;
        } else {
            resultBean.setErrorCode(ErrorCodeType.SYSTEM_ERROR);
            return resultBean;
        }
    }

}
