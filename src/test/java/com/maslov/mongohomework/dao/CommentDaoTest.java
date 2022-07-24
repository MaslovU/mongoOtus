//package com.maslov.mongohomework.dao;
//
//import com.maslov.mongohomework.domain.Comment;
//import com.maslov.mongohomework.exception.MongoMaslovException;
//import com.maslov.mongohomework.repository.CommentRepo;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class CommentDaoTest {
//    private static final String ID_OF_COMMENT = "1";
//    private static final String FIRST_COMM = "no";
//    private static final String SECOND_COMMENT = "second comment";
//    private static final String UPDATE_COMMENT = "update comment";
//    private static final String ERROR_MESSAGE = "No comment for this ID";
//
//    @Autowired
//    private CommentRepo commentRepo;
//
////    @Test
////    void getCommentById() {
////        Comment comment = commentRepo.findById(ID_OF_COMMENT).orElseThrow();
////
////        assertThat(comment.getCommentForBook()).isEqualTo(FIRST_COMM);
////    }
//
////    @Test
////    void createComment() {
////        String commentId = commentRepo.save(new Comment(SECOND_COMMENT)).getId();
////
////        assertThat(commentRepo.findById(commentId).orElseThrow().getCommentForBook()).isEqualTo(SECOND_COMMENT);
////    }
//
////    @Test
////    void updateComment() {
////        Comment commentFromDB = commentRepo.findById(ID_OF_COMMENT).get();
////        BeanUtils.copyProperties(new Comment(UPDATE_COMMENT), commentFromDB, "id");
////        commentRepo.save(commentFromDB);
////
////        assertThat(commentRepo.findById(ID_OF_COMMENT).orElseThrow().getCommentForBook()).isEqualTo(UPDATE_COMMENT);
////    }
//
////    @Test
////    void deleteComment() {
////        commentRepo.delete(new Comment(FIRST_COMM));
////
////        try {
////            commentRepo.findById(ID_OF_COMMENT);
////        } catch (MongoMaslovException e) {
////            assertEquals(ERROR_MESSAGE, e.getMessage());
////        }
////    }
//}