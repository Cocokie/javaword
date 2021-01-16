package com.security.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.demo.domain.MyUsers;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyUsersMapper extends BaseMapper<MyUsers> {
}
