package com.yuan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String sex;

    public User(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
}
