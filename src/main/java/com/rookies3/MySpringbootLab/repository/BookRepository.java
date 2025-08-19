package com.rookies3.MySpringbootLab.repository;

import com.rookies3.MySpringbootLab.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // isbn으로 책 찾기 (단일)
    Optional<Book> findByIsbn(String isbn);

    // author로 책 찾기 (여러 권일 수 있음)
    List<Book> findByAuthor(String author);
}
