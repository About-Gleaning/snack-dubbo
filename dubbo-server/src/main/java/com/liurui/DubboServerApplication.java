package com.liurui;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName DubboServerApplication
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:30
 **/
@SpringBootApplication
@EnableDubboConfiguration
public class DubboServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboServerApplication.class, args);
    }
}
