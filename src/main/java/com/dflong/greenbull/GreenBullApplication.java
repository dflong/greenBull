package com.dflong.greenbull;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 要启动mysql、redis、zookeeper、kafka
 */
@SpringBootApplication
@MapperScan("com.dflong.greenbull.mapper") // 同@Mapper注解
public class GreenBullApplication {

    public static void main(String[] args) {
        System.out.println("vehicle_contract_groups2".hashCode() % 50);
        SpringApplication.run(GreenBullApplication.class, args);
    }

}
