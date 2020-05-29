package com.lix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private List<Address> adds;
    private Info info;
    private String sd;
}
