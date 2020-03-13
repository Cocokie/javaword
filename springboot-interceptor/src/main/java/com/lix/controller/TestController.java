package com.lix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: areca-parent
 * @description: 测试
 * @author: lixin
 * @create: 2020-01-16 10:09
 **/
@RestController
public class TestController {
    @GetMapping("get")
    public String get() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("3698");
        return "ok";
    }
}
