package com.maslov.mongohomework.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comments")
public class Comment {
    @Id
    private String id;

    @Field(name = "comment_book")
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
}
