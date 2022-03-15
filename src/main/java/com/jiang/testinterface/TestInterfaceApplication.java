package com.jiang.testinterface;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jiang"})
@MapperScan("com.jiang.testinterface.mapper")
public class TestInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestInterfaceApplication.class, args);
    }

}
