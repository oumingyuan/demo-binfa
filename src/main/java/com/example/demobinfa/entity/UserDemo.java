package com.example.demobinfa.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserDemo {

    @Id
    private Integer userDemoId;
    private String data;
    private String name;
    private String address;
}
