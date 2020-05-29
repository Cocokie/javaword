package com.lix.mybatis.mapper;

import com.lix.mybatis.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    User getUserById(String id);
}
