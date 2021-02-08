package com.lix.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User>{
    private String username;
    private Integer age;

    @Override
    public int compareTo(User o) {
        return this.getAge()>o.getAge()?1:(this.getAge()==o.getAge())?0:-1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
