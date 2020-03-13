package com.lix;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: javaworld
 * @description:
 * @author: lixin
 * @create: 2020-01-16 13:32
 **/
@SpringBootApplication
public class InterceptorApp {
    public static void main(String[] args) {
        String sd = "['29c47690ce1441a1a0b2811074200016']";
        System.out.println(JSON.parseArray(sd));
        SpringApplication.run(InterceptorApp.class);
    }
}
