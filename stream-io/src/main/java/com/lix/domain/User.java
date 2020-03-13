package com.lix.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: javaworld
 * @description: user
 * @author: lixin
 * @create: 2020-03-11 10:20
 **/
@Data
public class User implements Serializable {
    String name;
    Integer age;
    String address;
}
