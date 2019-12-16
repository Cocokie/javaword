package com.lix.customize;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor
@Data
public class User {
    private String name;
    private Integer age;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(name, user.name);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
