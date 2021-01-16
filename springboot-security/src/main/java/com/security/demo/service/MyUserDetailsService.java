package com.security.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.security.demo.domain.MyUsers;
import com.security.demo.domain.Users;
import com.security.demo.mapper.MyUsersMapper;
import com.security.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
     @Autowired
     MyUsersMapper myUsersMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<MyUsers> wrapper = new QueryWrapper();
        wrapper.eq("username",s);
        MyUsers users = myUsersMapper.selectOne(wrapper);
        if(users == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        System.out.println(users);
        String role = users.getRole();
        List<String> strings = Arrays.asList(role.split(","));
        List<GrantedAuthority> auths = new ArrayList<>();

        strings.forEach(str->{
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(str);
            auths.add(grantedAuthority);
        });

        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()),auths);
    }
}
