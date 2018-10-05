package com.liurui;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName DubboClientApplication
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:33
 **/
@SpringBootApplication
@EnableDubboConfiguration
public class DubboClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }
}
