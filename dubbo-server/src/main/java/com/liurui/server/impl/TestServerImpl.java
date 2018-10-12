package com.liurui.server.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liurui.dao.UserInfoMapper;
import com.liurui.entity.UserInfo;
import com.liurui.server.TestServer;
import com.liurui.utils.UuidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    private static final Logger logger = LoggerFactory.getLogger(TestServerImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisTemplate redisTemplate;

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
        logger.info("yo yo qie ke nao");
        List<UserInfo> list = userInfoMapper.selectList(new QueryWrapper<UserInfo>());
        list.stream().forEach(e -> {
            redisTemplate.opsForValue().set(e.getId(), e.getName());
        });
        return list;
    }


}
