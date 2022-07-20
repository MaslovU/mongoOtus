package com.maslov.mongohomework.impl;

import com.maslov.mongohomework.domain.Author;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.repository.BookRepo;
import com.maslov.mongohomework.service.BookService;
import com.maslov.mongohomework.service.BookServiceHelper;
import com.maslov.mongohomework.service.ScannerHelper;
import com.maslov.mongohomework.service.impl.BookServiceImpl;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@SpringJUnitConfig(BookServiceImpl.class)
class BookServiceImplTest {

    private static final String TEST = "Test";
    @MockBean
    private ScannerHelper scanner;
    @MockBean
    private BookRepo bookRepo;
    @MockBean
    private BookServiceHelper bookServiceHelper;

    @Autowired
    BookService service;

//    @Test
//    void getBook() {
//
//        when(scanner.getFromUser()).thenReturn("0");
//
//        service.getBook();
//
//        verify(bookRepo, Mockito.times(0)).findById("1");
//
//    }

    @Test
    void createBook() {

//        val author = new Author("Lafore");
//        val authors = Collections.singletonList(author);
//        val year = "2021";
//        val genre = "labuda";
//        val comment = "Third";
//        val comment2 = "Five";
//        List<Comment> list = List.of(new Comment(comment), new Comment(comment2));
//
//        var book = new Book(TEST, genre, year, authors, list);
//
//        when(bookServiceHelper.getBookFromUser("0")).thenReturn(book);
//
//        service.createBook();
//
//        verify(bookRepo, Mockito.times(1)).save(book);
    }

    @Test
    void updateBook() {
//        val author = new Author("Lafore");
//        val authors = Collections.singletonList(author);
//        val year = "2021";
//        val genre = "labuda";
//        val comment = "Third";
//        val comment2 = "Five";
//        List<Comment> list = List.of(new Comment(comment), new Comment(comment2));
//
//        var book = new Book(TEST, genre, year, authors, list);
//
//        when(scanner.getFromUser()).thenReturn("5");
//        when(scanner.getEmptyString()).thenReturn("");
//        when(bookRepo.findById("5")).thenReturn(Optional.of(book));
//
//        service.updateBook();
//
//        verify(bookRepo, Mockito.times(1))
//                .save(any());
    }

//    @Test
//    void delBook() {
//        when(scanner.getFromUser()).thenReturn("1");
//
//        service.delBook();
//
//        verify(bookRepo, Mockito.times(1)).deleteById(anyString());
//    }

//    @Test
//    void delBookWithZeroId() {
//        when(scanner.getFromUser()).thenReturn("0");
//
//        service.delBook();
//
//        verify(bookRepo, Mockito.times(0)).deleteById(anyString());
//    }
}