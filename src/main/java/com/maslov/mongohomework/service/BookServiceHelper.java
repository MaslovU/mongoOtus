package com.maslov.mongohomework.service;

import com.maslov.mongohomework.domain.Author;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.domain.Genre;
import com.maslov.mongohomework.domain.YearOfPublish;
import com.maslov.mongohomework.exception.MongoMaslovException;
import com.maslov.mongohomework.repository.AuthorRepo;
import com.maslov.mongohomework.repository.BookRepo;
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

    public BookServiceHelper(ScannerHelper helper, AuthorRepo authorRepo, BookRepo bookRepo) {
        this.helper = helper;
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    public Book getBookFromUser(String idOfBook) {
        String name = getNameOfBook(idOfBook);
        Genre genre = getGenre(name);
//        List<Author> authors = getListAuthors(idOfBook);
        YearOfPublish year = getYear(name);
        List<Comment> comments = getComments(idOfBook);

        Book book = new Book();
//        book.setAuthor(authors);
        book.setName(name);
        book.setGenre(genre);
        book.setListOfComment(comments);
        book.setYear(year);
        return book;
    }

    private String getNameOfBook(String idOfBook) {
        System.out.println("Enter name of the book");
        String name = helper.getFromUser();
        if (name.isEmpty()) {
            try {
                return bookRepo.findById(idOfBook).orElseThrow().getName();
            } catch (Exception e) {
                System.out.println("Has not this book, need enter new name");
                throw new MongoMaslovException("Has not this book, need enter new name");
            }

        } else {
            return name;
        }
    }

    private String getAuthorId(String authorName) {
        if (authorRepo.findByName(authorName).isEmpty()) {
            Author author = authorRepo.save(new Author(authorName));
            return author.getId();
        } else {
            return authorRepo.findByName(authorName).get(0).getId();
        }
    }

//    private List<Author> getListAuthors(String idOfBook) {
//        System.out.println("Enter new names of the authors");
//        List<String> authorNames = List.of(helper.getFromUser().split(","));
//        List<Author> authors = new ArrayList<>();
//        if (authorNames.get(0).isEmpty() && authorNames.size() == 1) {
//            try {
//                return bookRepo.findById(idOfBook).orElseThrow().getAuthor();
//            } catch (NoSuchElementException e) {
//                throw new MongoMaslovException("Has not authors for this book. Need enter names");
//            }
//        } else {
//            for (String s : authorNames) {
//                String authorId = getAuthorId(s);
//                Author author = new Author(s);
//                authors.add(author);
//            }
//            return authors;
//        }
//    }

    private YearOfPublish getYear(String nameOfBook) {
        System.out.println("Enter new years of publish");
        String year = helper.getFromUser();
        if (year.isEmpty()) {
            return bookRepo.getBooksByName(nameOfBook).get(0).getYear();
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

    private List<Comment> getComments(String ibOfBook) {
        System.out.println("You can add comment to this book or press enter");
        String comment = helper.getFromUser();
        if (comment.isEmpty()) {
            try {
                return bookRepo.findById(ibOfBook).orElseThrow().getListOfComment();
            } catch (NoSuchElementException | NullPointerException e) {
                return new ArrayList<>();
            }
        } else {
            val comm = new Comment(comment);
            List<Comment> comments = bookRepo.findById(ibOfBook).orElseThrow().getListOfComment();
            comments.add(comm);
            return comments;
        }
    }
}
