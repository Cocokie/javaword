package com.lix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Comparable<User> {
    private String name;
    private Integer age;


    @Override
    public int compareTo(User o) {
        return o.age-this.age;
    }
}
