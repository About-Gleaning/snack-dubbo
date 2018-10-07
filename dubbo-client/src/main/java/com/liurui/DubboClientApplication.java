package com.liurui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName DubboClientApplication
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:33
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource({"classpath:dubbo-consumer.xml"})
public class DubboClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }
}
