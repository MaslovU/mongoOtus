package com.maslov.mongohomework.domain;

import org.springframework.data.annotation.Id;

public class YearOfPublish {

    @Id
    private String id;

    private String title;

    public YearOfPublish() {
    }

    public YearOfPublish(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "YearOfPublish{" +
                "title='" + title + '\'' +
                '}';
    }
}
