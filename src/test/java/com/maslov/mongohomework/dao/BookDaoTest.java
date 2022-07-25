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
}
