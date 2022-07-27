package com.maslov.mongohomework.service;

import com.maslov.mongohomework.domain.Author;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.domain.Genre;
import com.maslov.mongohomework.domain.YearOfPublish;
import com.maslov.mongohomework.exception.MongoMaslovException;
import com.maslov.mongohomework.repository.AuthorRepo;
import com.maslov.mongohomework.repository.BookRepo;
import com.maslov.mongohomework.repository.CommentRepo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class BookServiceHelper {

    private final ScannerHelper helper;
    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    private final CommentRepo commentRepo;

    public BookServiceHelper(ScannerHelper helper, AuthorRepo authorRepo, BookRepo bookRepo, CommentRepo commentRepo) {
        this.helper = helper;
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.commentRepo = commentRepo;
    }

    public Book getBookFromUser(String idOfBook) {
        String name = getNameOfBook(idOfBook);
        Book book = new Book(name);

        List<Author> authors = new ArrayList<>();
        book.setAuthors(authors);

        List<Comment> comments = new ArrayList<>();
        book.setListOfComment(comments);

        Genre genre = getGenre(name);
        YearOfPublish year = getYear(name);

        book = getListAuthors(book);
        book = getComments(book);
        book.setGenre(genre);
        book.setYear(year);

        return book;
    }

    private String getNameOfBook(String idOfBook) {
        System.out.println("Enter name of the book");
        String name = helper.getFromUser();
        if (name.isEmpty()) {
            try {
                return bookRepo.findById(Integer.valueOf(idOfBook)).orElseThrow().getName();
            } catch (Exception e) {
                System.out.println("Has not this book, need enter new name");
                throw new MongoMaslovException("Has not this book, need enter new name");
            }

        } else {
            return name;
        }
    }

    private Author getAuthor(String authorName) {
        if (authorRepo.findByName(authorName).isEmpty()) {
            return authorRepo.save(new Author(authorName));
        } else {
            Author author = authorRepo.findByName(authorName).get(0);
            return author;
        }
    }

    private Book getListAuthors(Book book) {
        System.out.println("Enter new names of the authors");
        List<String> authorNames = List.of(helper.getFromUser().split(","));
        if (authorNames.get(0).isEmpty() && authorNames.size() == 1) {
            try {
                return bookRepo.findById(Integer.valueOf(book.getId())).orElseThrow();
            } catch (NoSuchElementException e) {
                throw new MongoMaslovException("Has not authors for this book. Need enter names");
            }
        } else {
            for (String s : authorNames) {
                book.getAuthors().add(getAuthor(s));
            }
            return book;
        }
    }

    private YearOfPublish getYear(String nameOfBook) {
        System.out.println("Enter new years of publish");
        String year = helper.getFromUser();
        if (year.isEmpty()) {
            try {
                return bookRepo.getBooksByName(nameOfBook).get(0).getYear();
            } catch (IndexOutOfBoundsException e) {
                return new YearOfPublish("");
            }
        } else {
            return new YearOfPublish(year);
        }
    }

    private Genre getGenre(String nameOfBook) {
        System.out.println("Enter new name of the genre");
        String genre = helper.getFromUser();
        if (genre.isEmpty()) {
            return bookRepo.getBooksByName(nameOfBook).get(0).getGenre();
        } else {
            return new Genre(nameOfBook);
        }
    }

    private Book getComments(Book book) {
        System.out.println("You can add comment to this book or press enter");
        String commentFromUser = helper.getFromUser();
        if (commentFromUser.isEmpty()) {
            return bookRepo.findById(Integer.valueOf(book.getId())).orElseThrow();
        } else {
            book.getListOfComment().add(commentRepo.save(new Comment(commentFromUser)));
            return book;
        }
    }
}
