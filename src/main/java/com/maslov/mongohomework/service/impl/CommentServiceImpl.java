package com.maslov.mongohomework.service.impl;

import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.domain.Comment;
import com.maslov.mongohomework.repository.BookRepo;
import com.maslov.mongohomework.repository.CommentRepo;
import com.maslov.mongohomework.service.CommentService;
import com.maslov.mongohomework.service.ScannerHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final ScannerHelper helper;
    private final BookRepo bookRepo;
    private final CommentRepo commentRepo;

    public CommentServiceImpl(ScannerHelper helper, BookRepo bookRepo, CommentRepo commentRepo) {
        this.helper = helper;
        this.bookRepo = bookRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public List<Comment> getAllCommentsForBook() {
        int idOfBook = Integer.parseInt(getIdForBook());
        return bookRepo.findById(idOfBook).orElseThrow().getListOfComment();
    }

    @Override
    public List<Comment> createComment() {
        String idForBook = getIdForBook();
        helper.getEmptyString();
        System.out.println("Enter your comment");
        Comment comm = new Comment(helper.getFromUser());
        Comment addedComment = commentRepo.save(comm);
        Book bookFromDB = bookRepo.findById(Integer.valueOf(idForBook)).orElseThrow();
        List<Comment> commentList = bookFromDB.getListOfComment();
        commentList.add(addedComment);
        Book book = new Book(bookFromDB.getName(),
                bookFromDB.getGenre(),
                bookFromDB.getYear(),
                bookFromDB.getAuthors(),
                commentList);
        BeanUtils.copyProperties(book, bookFromDB, "id");
        bookRepo.save(bookFromDB);
        return commentList;
    }

    @Override
    public List<Comment> updateComment() {
        String idForBook = getIdForBook();
        String idComment = getCommentId(idForBook);
        helper.getEmptyString();
        Comment commentFromDB = commentRepo.findById(Integer.valueOf(idComment)).orElseThrow();
        System.out.println("Enter correct comment");
        String newComment = helper.getFromUser();
        Comment comment = new Comment(newComment);
        BeanUtils.copyProperties(comment, commentFromDB, "id");
        commentRepo.save(commentFromDB);
        return bookRepo.findById(Integer.valueOf(idForBook)).orElseThrow().getListOfComment();
    }

    @Override
    public List<Comment> deleteComment() {
        String idForBook = getIdForBook();
        String idForComment = getCommentId(idForBook);
        Comment comment = commentRepo.findById(Integer.valueOf(idForComment)).orElseThrow();
        commentRepo.deleteById(comment.getId());
        return bookRepo.findById(Integer.valueOf(idForBook)).orElseThrow().getListOfComment();
    }

    private String getIdForBook() {
        System.out.println("Enter name for book");
        String nameOfBook = helper.getFromUser();
        List<Book> listOfBooks = bookRepo.getBooksByName(nameOfBook);
        for (Book b : listOfBooks) {
            System.out.println(b);
        }
        System.out.println("Find id your book and enter it");
        return helper.getFromUser();
    }

    private String getCommentId(String idForBook) {

        for (Comment c : bookRepo.findById(Integer.valueOf(idForBook)).orElseThrow().getListOfComment()) {
            System.out.println(c);
        }
        System.out.println("Choose and enter id of comment");
        return helper.getFromUser();
    }
}
