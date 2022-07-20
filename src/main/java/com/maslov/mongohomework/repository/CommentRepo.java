package com.maslov.mongohomework.repository;

import com.maslov.mongohomework.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepo extends MongoRepository<Comment, Integer> {

}
