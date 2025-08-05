package com.dflong.greenbull;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dflong.greenbull.mapper") // 同@Mapper注解
public class GreenBullApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreenBullApplication.class, args);
    }

}
