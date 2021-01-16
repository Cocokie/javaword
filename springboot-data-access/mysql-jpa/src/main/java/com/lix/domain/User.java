package com.lix.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "transition")
public class User {
    @Id
    private String username;

    private Double amount;
}
