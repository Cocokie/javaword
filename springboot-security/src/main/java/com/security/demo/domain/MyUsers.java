package com.security.demo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "myuser")
public class MyUsers {
    @TableId
    private Integer id;
    private String username;
    private String password;
    private String role;

}
