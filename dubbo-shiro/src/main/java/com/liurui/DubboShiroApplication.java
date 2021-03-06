package com.liurui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * @ClassName DubboShiroApplication
 * @Description TODO
 * @Author liurui
 * @Date 2018/10/16 下午3:10
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ImportResource({"classpath:dubbo-consumer.xml"})
public class DubboShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboShiroApplication.class, args);
    }
}
