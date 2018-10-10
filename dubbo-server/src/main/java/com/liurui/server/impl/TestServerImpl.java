package com.liurui.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liurui.dao.UserInfoMapper;
import com.liurui.entity.UserInfo;
import com.liurui.server.TestServer;
import com.liurui.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName TestServerImpl
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:30
 **/
@Service("com.liurui.server.impl.TestServerImpl")
@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
public class TestServerImpl implements TestServer {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public String sayHello(String str) {
        return "say hello " + str + "from dubbo-server";
    }

    @Override
    public Integer saveUserInfo(UserInfo userInfo) {
        try {
            userInfo.setId(UuidUtils.get32UUID());
            return userInfoMapper.insert(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<UserInfo> getList() {
        UserInfo user = userInfoMapper.selectByPrimaryKey("5e7a89031f5a4e859f382f8e4502a79a");
        List<UserInfo> list = userInfoMapper.selectList(null);
        Wrapper<UserInfo> wrapper = new QueryWrapper<>();
        List<UserInfo> list1 = userInfoMapper.selectList(new QueryWrapper<UserInfo>().like("name", "liu"));
        IPage<UserInfo> list2 = userInfoMapper.selectPage(new Page<>(1, 2), null);
        return list;
    }


}
