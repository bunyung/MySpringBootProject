package com.rookies3.MySpringbootLab.dto;

import java.time.LocalDate;

public class BookDTO {

    public static class BookCreateRequest {
        private String title;
        private String author;
        private String isbn;
        private Integer price;
        private LocalDate publishDate;

        // getter/setter
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
        public String getIsbn() { return isbn; }
        public void setIsbn(String isbn) { this.isbn = isbn; }
        public Integer getPrice() { return price; }
        public void setPrice(Integer price) { this.price = price; }
        public LocalDate getPublishDate() { return publishDate; }
        public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }
    }

    public static class BookUpdateRequest {
        private String title;
        private String author;
        private Integer price;
        private LocalDate publishDate;

        // getter/setter
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }
        public Integer getPrice() { return price; }
        public void setPrice(Integer price) { this.price = price; }
        public LocalDate getPublishDate() { return publishDate; }
        public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }
    }

    public static class BookResponse {
        private Long id;
        private String title;
        private String author;
        private String isbn;
        private Integer price;
        private LocalDate publishDate;

        // 생성자
        public BookResponse(Long id, String title, String author, String isbn, Integer price, LocalDate publishDate) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.price = price;
            this.publishDate = publishDate;
        }

        // getter
        public Long getId() { return id; }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public String getIsbn() { return isbn; }
        public Integer getPrice() { return price; }
        public LocalDate getPublishDate() { return publishDate; }
    }
}
