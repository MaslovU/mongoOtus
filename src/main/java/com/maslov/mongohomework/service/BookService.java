package com.maslov.mongohomework.service;

import com.maslov.mongohomework.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookService {
    void getBook();

    void getAllBook();

    Book createBook();

    void updateBook();

    void delBook();
}
