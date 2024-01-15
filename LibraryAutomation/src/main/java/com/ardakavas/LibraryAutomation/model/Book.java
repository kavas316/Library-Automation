package com.ardakavas.LibraryAutomation.model;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String book_name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;

    private Integer publication_year;


    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Author getAuthor_id() {
        return author;
    }

    public void setAuthor_id(Author author_id) {
        this.author = author_id;
    }

    public Category getCategory_id() {
        return category;
    }

    public void setCategory_id(Category category_id) {
        this.category = category_id;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

}
