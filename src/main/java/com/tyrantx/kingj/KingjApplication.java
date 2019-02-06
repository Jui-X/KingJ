package com.tyrantx.kingj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan注解自动扫描Mapper包，无需在每个Mapper类上加@Mapper注解
@SpringBootApplication
@MapperScan("com.tyrantx.king.mapper")
public class KingjApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingjApplication.class, args);
    }

}

