package com.ardakavas.LibraryAutomation.repository;

import com.ardakavas.LibraryAutomation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.category.category_id = :category_id")
    List<Book> findBooksByCategoryId(Long category_id);


    @Query("Select b from Book b WHERE b.author.author_id = :author_id")
    List<Book> findBooksByAuthorId(Long author_id);

    List<Book> fndByOrderByPublicationYearAsc();

}
