package com.rookies3.MySpringbootLab.service;

import com.rookies3.MySpringbootLab.dto.BookDTO.BookCreateRequest;
import com.rookies3.MySpringbootLab.dto.BookDTO.BookUpdateRequest;
import com.rookies3.MySpringbootLab.dto.BookDTO.BookResponse;
import com.rookies3.MySpringbootLab.entity.Book;
import com.rookies3.MySpringbootLab.repository.BookRepository;
import com.rookies3.MySpringbootLab.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 도서 등록
    public BookResponse createBook(BookCreateRequest request) {
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getIsbn(),
                request.getPrice(),
                request.getPublishDate()
        );
        Book saved = bookRepository.save(book);
        return toResponse(saved);
    }

    // 도서 수정
    public BookResponse updateBook(Long id, BookUpdateRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book not found with ID: " + id));

        if (request.getTitle() != null) book.setTitle(request.getTitle());
        if (request.getAuthor() != null) book.setAuthor(request.getAuthor());
        if (request.getPrice() != null) book.setPrice(request.getPrice());
        if (request.getPublishDate() != null) book.setPublishDate(request.getPublishDate());

        return toResponse(bookRepository.save(book));
    }

    // 모든 도서 조회
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // 단일 도서 조회
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book not found with ID: " + id));
        return toResponse(book);
    }

    // 단일 도서 조회 (ISBN)
    public BookResponse getBookByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BusinessException("Book not found with ISBN: " + isbn));
        return toResponse(book);
    }

    // 삭제
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Book not found with ID: " + id));
        bookRepository.delete(book);
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getPublishDate()
        );
    }
}
