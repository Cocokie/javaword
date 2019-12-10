package com.lix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lix.mapper")
public class SpringbootSimpleMybatis_App {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSimpleMybatis_App.class);
    }
}
