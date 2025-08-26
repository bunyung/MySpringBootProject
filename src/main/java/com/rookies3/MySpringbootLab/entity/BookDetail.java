package com.rookies3.MySpringbootLab.entity;

import jakarta.persistence.*;

@Entity
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pageCount;
    private String publisher;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BookDetail() {}

    // Getter / Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getPageCount() { return pageCount; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}
