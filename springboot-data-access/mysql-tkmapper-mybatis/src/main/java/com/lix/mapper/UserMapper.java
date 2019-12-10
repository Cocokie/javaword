package com.lix.mapper;

import com.lix.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select("select * from transition")
    List<User> queryAll();
}
