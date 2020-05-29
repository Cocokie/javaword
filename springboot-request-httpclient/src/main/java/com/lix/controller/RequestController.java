package com.lix.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {


    @PostMapping("getNoArg")
    public String getNoArg(@RequestParam List<String> userIds) {

        System.out.println(JSON.toJSONString(userIds));

        return JSON.toJSONString(userIds);
    }

    @GetMapping("getArg")
    public String getArg(String name, String age) {
        return "success";
    }

    @PostMapping("postForm")
    public String postForm(@RequestParam List<String> userIds) {
        System.out.println(userIds);
        return "success";
    }

    @PostMapping("postJson")
    public String postJson() {
        return "success";
    }
}
