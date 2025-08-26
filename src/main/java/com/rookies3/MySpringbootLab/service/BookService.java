package com.rookies3.MySpringbootLab.service;

import com.rookies3.MySpringbootLab.entity.Book;
import com.rookies3.MySpringbootLab.repository.BookRepository;
import com.rookies3.MySpringbootLab.exception.BookNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 전체 조회
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ID로 조회
    public Book getBookByIdOrThrow(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("해당 도서를 찾을 수 없습니다."));
    }

    // ISBN으로 조회
    public Optional<Book> getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    // 도서 생성
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // PUT 전체 수정
    public Book updateBook(Long id, Book request) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        existingBook.setTitle(request.getTitle());
        existingBook.setAuthor(request.getAuthor());
        existingBook.setIsbn(request.getIsbn());
        existingBook.setPrice(request.getPrice());
        existingBook.setPublishDate(request.getPublishDate());

        return bookRepository.save(existingBook);
    }

    // PATCH 부분 수정
    public Book patchBook(Long id, Book request) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);

        if (request.getTitle() != null) existingBook.setTitle(request.getTitle());
        if (request.getAuthor() != null) existingBook.setAuthor(request.getAuthor());
        if (request.getIsbn() != null) existingBook.setIsbn(request.getIsbn());
        if (request.getPrice() != null) existingBook.setPrice(request.getPrice());
        if (request.getPublishDate() != null) existingBook.setPublishDate(request.getPublishDate());

        return bookRepository.save(existingBook);
    }

    // DELETE 메서드 수정
    public void deleteBook(Long id) {
        Book book = getBookByIdOrThrow(id); // 없으면 예외 발생
        bookRepository.delete(book);
    }
}
