package com.maslov.mongohomework.repository;

import com.maslov.mongohomework.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepo extends MongoRepository<Book, Integer> {

    List<Book> getBooksByName(String name);
}
