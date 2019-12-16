package com.lix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Dish implements Comparable<Dish>{
    String name;
    Integer energy;

    @Override
    public int compareTo(Dish o) {
        return o.getEnergy()-this.energy;
    }
}
