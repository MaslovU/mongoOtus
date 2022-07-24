package com.maslov.mongohomework.dao;

import com.maslov.mongohomework.AbstractRepositoryTest;
import com.maslov.mongohomework.domain.Book;
import com.maslov.mongohomework.repository.BookRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookDaoTest extends AbstractRepositoryTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    void getAllBook() {
        List<Book> list = bookRepo.findAll();

        assertThat(list.size()).isNotZero();
    }
//
//    @Test
//    void getBookById() {
////        Book book = bookRepo.findById(ID).orElseThrow();
////
////        List<Author> authors = book.getAuthor();
////        List<String> authorsName = new ArrayList<>();
////        for (Author a : authors) {
////            authorsName.add(a.getName());
////        }
////
////        BookModel model = BookModel.builder()
////                .name(book.getName())
////                .authors(String.valueOf(authorsName))
////                .genre(book.getGenre())
////                .year(book.getYear())
////                .build();
////
////        System.out.println(model);
////        assertThat(book.getName()).isEqualTo(JAVA);
////        assertThat(model.getGenre()).isEqualTo(STUDYING);
//    }
//
////    @Test
////    void getBooksByName() {
////        List<Book> books = bookRepo.getBooksByName(JAVA);
////
////        assertThat(books.get(0)).isEqualTo(ID);
////    }
//
//    @Test
//    void createBook() {
//
////        val author = new Author("Lafore");
////        val authors = Collections.singletonList(author);
////        val year = "2021";
////        val genre = "labuda";
////        val comment = "Third";
////        val comment2 = "Five";
////        List<Comment> list = List.of(new Comment(comment), new Comment(comment2));
////
////        var book = new Book(TEST, genre, year, authors, list);
////
////        Book createdBook = bookRepo.save(book);
////
////        assertThat(createdBook.getName()).isEqualTo(TEST);
//    }
//
//    @Test
//    void updateBook() {
////        List<Author> authors = new ArrayList<>();
////        authors.add(new Author(AUTHOR));
////        String genre = "test";
////        String year = "2015";
////        List<Comment> comments = new ArrayList<>();
////        val comment = "Third";
////        val comment2 = "Five";
////        List<Comment> list = List.of(new Comment(comment), new Comment(comment2));
////        Book book = new Book(TEST, genre, year, authors, list);
////        Book bookFromDB = bookRepo.findById("5").orElseThrow();
////        BeanUtils.copyProperties(book, bookFromDB, "id");
////
////        Book updatedBook = bookRepo.save(bookFromDB);
////
////        assertThat(updatedBook.getName()).isEqualTo(TEST);
//    }
//
////    @Test
////    void deleteBook() {
////        List<Book> booksBefore = bookRepo.findAll();
////        bookRepo.deleteById(ID_FOR_DELETE);
////        List<Book> booksAfter = bookRepo.findAll();
////
////        assertThat(booksAfter).hasSize(booksBefore.size() - 1);
////    }
}
