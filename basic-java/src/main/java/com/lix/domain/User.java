package com.lix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Comparable<User>{
    private String name;
    private Integer age;


    public int compareTo(User o) {
        return 0;
    }
}
