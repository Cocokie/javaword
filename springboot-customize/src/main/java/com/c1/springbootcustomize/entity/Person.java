package com.c1.springbootcustomize.entity;


import lombok.Data;

import java.util.Map;

@Data
public class Person implements Cloneable{
    User user;
    String type;
    Map map ;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
