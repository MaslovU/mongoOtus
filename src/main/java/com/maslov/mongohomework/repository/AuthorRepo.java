package com.maslov.mongohomework.repository;

import com.maslov.mongohomework.domain.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepo extends MongoRepository<Author, Integer> {
    List<Author> findByName(String text);
}
