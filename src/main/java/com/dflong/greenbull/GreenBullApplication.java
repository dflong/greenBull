package com.dflong.greenbull;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * 要启动mysql、redis、zookeeper、kafka
 */
@SpringBootApplication
@MapperScan("com.dflong.greenbull.mapper") // 同@Mapper注解
public class GreenBullApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenBullApplication.class, args);
    }

    @Autowired
    Environment env;

}
