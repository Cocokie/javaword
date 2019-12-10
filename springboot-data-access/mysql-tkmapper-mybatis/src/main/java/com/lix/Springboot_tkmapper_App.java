package com.lix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lix.mapper")
public class Springboot_tkmapper_App {
    public static void main(String[] args) {
        SpringApplication.run(Springboot_tkmapper_App.class);
    }
}
