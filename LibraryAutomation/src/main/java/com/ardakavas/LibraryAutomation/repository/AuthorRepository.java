package com.ardakavas.LibraryAutomation.repository;


import com.ardakavas.LibraryAutomation.model.Author;
import com.ardakavas.LibraryAutomation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("Select b from Book b WHERE b.author.author_id = :author_id")
    List<Book> findBooksByAuthorId(Long author_id);



  //  @Query("SELECT a FROM authors a WHERE a.author_name = :author_name")
   // Optional<Author> findByAuthorName(String authorName);

}
