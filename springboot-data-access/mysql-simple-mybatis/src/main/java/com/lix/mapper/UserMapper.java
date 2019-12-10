package com.lix.mapper;

import com.lix.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from transition")
    List<User> queryAll();
}
