package com.liurui.server.impl;

import com.liurui.dao.UserInfoMapper;
import com.liurui.entity.UserInfo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestServerImplTest extends TestCase {

    @Autowired
    private TestServerImpl testServer;

    @Test
    public void testGetList() {
        List<UserInfo> userInfoList = testServer.getList();
        userInfoList.stream().forEach(e -> {
            System.out.println(e.getName());
        });
    }
}