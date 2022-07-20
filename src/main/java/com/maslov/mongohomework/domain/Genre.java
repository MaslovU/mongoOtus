package com.maslov.mongohomework.domain;

import org.springframework.data.annotation.Id;

public class Genre {

    @Id
    private String id;

    private String name;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
