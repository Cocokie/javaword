package com.lix.controller;

import com.lix.domain.User;
import com.lix.service.UserService;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class UserController {
    private UserService userService;
    private String name;
    private List<String> names;
    private List<User> users;
    private Map<String,String> stringMap;
    private Map<String,String> objMap;


    public void getUser() {
        System.out.println("UserController.getUser");
        userService.getUser();
}

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
