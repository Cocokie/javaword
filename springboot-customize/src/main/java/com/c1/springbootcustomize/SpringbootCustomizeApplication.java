package com.c1.springbootcustomize;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.c1.springbootcustomize.dao")
public class SpringbootCustomizeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCustomizeApplication.class, args);
    }

}
