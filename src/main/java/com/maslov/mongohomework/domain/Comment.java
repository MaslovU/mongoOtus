package com.maslov.mongohomework.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;

    private String commentForBook;

    public Comment() {
    }

    public Comment(String commentForBook) {
        this.commentForBook = commentForBook;
    }

    public Integer getId() {
        return Integer.valueOf(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentForBook() {
        return commentForBook;
    }

    public void setCommentForBook(String commentForBook) {
        this.commentForBook = commentForBook;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentForBook='" + getCommentForBook() + '\'' +
                '}';
    }
}
