package com.c1.springbootcustomize.controller;

import com.c1.springbootcustomize.entity.User;
import com.c1.springbootcustomize.service.UserService;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.util.List;


/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-01-21 14:09:09
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @GetMapping("get")
    public List<User> get() {
        List<User> all = this.userService.getAll();
        return all;
    }

}