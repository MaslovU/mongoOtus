package com.maslov.mongohomework.service;

import com.maslov.mongohomework.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getAllCommentsForBook();

    List<Comment> createComment();

    List<Comment> updateComment();

    List<Comment> deleteComment();
}
