package com.lix.controller;

import com.lix.domain.User;
import com.lix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("get")
    public String transfer(String username,Double amount){
        userService.transfer(username,amount);
        return "xxx";
    }
    @GetMapping("time")
    public List<User> time(){

        return userService.time();
    }
}
