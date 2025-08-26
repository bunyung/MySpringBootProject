package com.rookies3.MySpringbootLab.controller;

import com.rookies3.MySpringbootLab.entity.Book;
import com.rookies3.MySpringbootLab.service.BookService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // 전체 조회
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // ID로 조회
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookByIdOrThrow(id); // 없으면 BookNotFoundException 발생
        return ResponseEntity.ok(book);
    }

    // ISBN으로 조회
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 도서 생성
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    // PUT 전체 수정
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book request) {
        try {
            Book updatedBook = bookService.updateBook(id, request);
            return ResponseEntity.ok(updatedBook);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // PATCH 부분 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Book> patchBook(@PathVariable Long id, @RequestBody Book request) {
        try {
            Book patchedBook = bookService.patchBook(id, request);
            return ResponseEntity.ok(patchedBook);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id); // 내부에서 getBookByIdOrThrow 호출, 없으면 예외 발생
        return ResponseEntity.noContent().build();
    }
}
