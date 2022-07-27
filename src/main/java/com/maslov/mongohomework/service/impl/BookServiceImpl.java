package com.maslov.mongohomework.service.impl;

import com.maslov.mongohomework.domain.Author;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.exception.MongoMaslovException;
import com.maslov.mongohomework.repository.BookRepo;
import com.maslov.mongohomework.service.BookService;
import com.maslov.mongohomework.service.BookServiceHelper;
import com.maslov.mongohomework.service.ScannerHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class BookServiceImpl implements BookService {
    private static final String ENTER_ID = "Enter ID for book or 0 is your dont now ID";
    private static final String GET_ALL = "Enter command 'getall' for search your book in list";

    private final BookRepo bookRepo;
    private final ScannerHelper helper;
    private final BookServiceHelper bookServiceHelper;

    public BookServiceImpl(BookRepo bookRepo, ScannerHelper helper, BookServiceHelper bookServiceHelper) {
        this.bookRepo = bookRepo;
        this.helper = helper;
        this.bookServiceHelper = bookServiceHelper;
    }

    @Override
    public void getBook() {
        System.out.println(ENTER_ID);
        int id = helper.getIntFromUser();
        if (id > 0) {
            Book book = bookRepo.findById(id).orElseThrow(() -> new MongoMaslovException("Book with this id is not exist"));
            System.out.println(book);
        } else {
            System.out.println(GET_ALL);
        }
    }

    @Override
    public void getAllBook() {
        List<Book> books = bookRepo.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    @Transactional
    public Book createBook() {
        Book book = bookServiceHelper.getBookFromUser("0");

        return bookRepo.save(book);
    }

    @Override
    @Transactional
    public void updateBook() {
        log.debug("Start updating book. if you don't want to change the value, click Enter");
        System.out.println(ENTER_ID);
        int id = helper.getIntFromUser();
        helper.getEmptyString();
        if (id == 0) {
            Book bookFromDB = bookRepo.findById(id).orElseThrow();
            BeanUtils.copyProperties(bookServiceHelper.getBookFromUser(String.valueOf(id)), bookFromDB, "id");
            bookRepo.save(bookFromDB);
        } else {
            System.out.println(GET_ALL);
        }
    }

    @Override
    public void delBook() {
        System.out.println(ENTER_ID);
        int id = helper.getIntFromUser();
        if (id != 0) {
            bookRepo.deleteById(id);
            log.info("Book deleted successfully");
        } else {
            System.out.println(GET_ALL);
        }
    }
}
