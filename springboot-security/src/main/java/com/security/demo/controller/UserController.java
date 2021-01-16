package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("get")
    public String get(){
        return "success";
    }
}
