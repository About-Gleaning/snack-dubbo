package com.liurui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName DubboServerApplication
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/5 下午8:30
 **/
@SpringBootApplication
@MapperScan("com.liurui.dao")
@ImportResource({"classpath:dubbo-provider.xml"})
public class DubboServerApplication {

//    private static final Logger logger = LoggerFactory.getLogger(DubboServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DubboServerApplication.class, args);
    }
}
