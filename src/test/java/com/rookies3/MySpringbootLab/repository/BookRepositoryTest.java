package com.rookies3.MySpringbootLab.repository;

import com.rookies3.MySpringbootLab.entity.Book; // Book import
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository; // BookRepository import 필요

    @Test
    @DisplayName("도서 등록 테스트")
    void testCreateBook() {
        Book book = new Book("스프링 부트 입문", "홍길동", "9788956746425", 30000, LocalDate.of(2025,5,7));
        Book savedBook = bookRepository.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("스프링 부트 입문");
    }

    // 나머지 테스트들도 동일하게 Book 생성자 순서 및 import 확인
}
