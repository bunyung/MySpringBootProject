package com.rookies3.MySpringbootLab.repository;

import com.rookies3.MySpringbootLab.entity.Book;
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
    private BookRepository bookRepository;

    @Test
    @DisplayName("도서 등록 테스트")
    void testCreateBook() {
        Book book = new Book("스프링 부트 입문", "홍길동", "9788956746425", LocalDate.of(2025, 5, 7), 30000);
        Book savedBook = bookRepository.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getTitle()).isEqualTo("스프링 부트 입문");
    }

    @Test
    @DisplayName("ISBN으로 도서 조회 테스트")
    void testFindByIsbn() {
        Book book = new Book("JPA 프로그래밍", "박둘리", "9788956746432", LocalDate.of(2025, 4, 30), 35000);
        bookRepository.save(book);

        Optional<Book> found = bookRepository.findByIsbn("9788956746432");
        assertThat(found).isPresent();
        assertThat(found.get().getAuthor()).isEqualTo("박둘리");
    }

    @Test
    @DisplayName("저자명으로 도서 목록 조회 테스트")
    void testFindByAuthor() {
        Book book1 = new Book("스프링 부트 입문", "홍길동", "9788956746425", LocalDate.of(2025, 5, 7), 30000);
        Book book2 = new Book("JPA 프로그래밍", "홍길동", "9788956746433", LocalDate.of(2025, 4, 30), 35000);
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> books = bookRepository.findByAuthor("홍길동");
        assertThat(books).hasSize(2);
    }

    @Test
    @DisplayName("도서 정보 수정 테스트")
    void testUpdateBook() {
        Book book = new Book("스프링 부트 입문", "홍길동", "9788956746425", LocalDate.of(2025, 5, 7), 30000);
        Book savedBook = bookRepository.save(book);

        savedBook.setPrice(32000);
        Book updatedBook = bookRepository.save(savedBook);

        assertThat(updatedBook.getPrice()).isEqualTo(32000);
    }

    @Test
    @DisplayName("도서 삭제 테스트")
    void testDeleteBook() {
        Book book = new Book("JPA 프로그래밍", "박둘리", "9788956746432", LocalDate.of(2025, 4, 30), 35000);
        Book savedBook = bookRepository.save(book);

        bookRepository.delete(savedBook);

        Optional<Book> deleted = bookRepository.findById(savedBook.getId());
        assertThat(deleted).isEmpty();
    }
}
