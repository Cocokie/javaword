package com.lix.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {


    @GetMapping("getNoArg")
    public String getNoArg() {
        return "success";
    }

    @GetMapping("getArg")
    public String getArg(String name, String age) {
        return "success";
    }

    @PostMapping("postForm")
    public String postForm() {
        return "success";
    }

    @PostMapping("postJson")
    public String postJson() {
        return "success";
    }
}
