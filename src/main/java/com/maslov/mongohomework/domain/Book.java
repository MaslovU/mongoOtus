package com.maslov.mongohomework.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "books")
public class Book {
    @Id
    private String id;

    private String name;

    private Genre genre;

    private YearOfPublish year;

    @DBRef
    private List<Author> authors;

    @DBRef
    private List<Comment> listOfComment;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, Genre genre, YearOfPublish year, List<Author> authors, List<Comment> comments) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.authors = authors;
        this.listOfComment = comments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public YearOfPublish getYear() {
        return year;
    }

    public void setYear(YearOfPublish year) {
        this.year = year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Comment> getListOfComment() {
        return listOfComment;
    }

    public void setListOfComment(List<Comment> listOfComment) {
        this.listOfComment = listOfComment;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", genre=" + genre +
                ", year=" + year +
                ", authors=" + authors +
                ", listOfComment=" + listOfComment +
                '}';
    }
}
