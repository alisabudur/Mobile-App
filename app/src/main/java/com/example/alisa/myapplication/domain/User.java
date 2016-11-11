package com.example.alisa.myapplication.domain;

/**
 * Created by Alisa on 11/3/2016.
 */

public class User {
    private Integer Id;
    private String name;

    public User(){}

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
