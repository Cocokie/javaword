package com.lix.service;

import com.lix.domain.User;
import com.lix.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userMapper;

    public void transfer(String username, Double amount) {
        List<User> all = userMapper.findAll();
//        List<User> userList = userMapper.queryAll();
        for (User user : all) {
            System.out.println(user);
        }

    }
}
