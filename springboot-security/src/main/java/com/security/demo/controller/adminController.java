package com.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class adminController {
    @GetMapping("admin")
    public String get(String name){
        return name;
    }
}
