package com.ardakavas.LibraryAutomation.service;


import com.ardakavas.LibraryAutomation.model.Author;
import com.ardakavas.LibraryAutomation.model.Book;
import com.ardakavas.LibraryAutomation.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    //Bütün yazarları çagırma
    public List<Author> getAllAuthor(){return authorRepository.findAll();}

    // Id ye göre yazar çagırma
    public Optional<Author> getAuthorById(Long author_id){
        return authorRepository.findById(author_id);
    }

    // İsme göre yazar cagırma

  //  public Optional<Author> getBookByName(String authorName){
   //     return authorRepository.findByAuthorName(authorName);
   // }

    // Yazar oluşturma

    public Author createAuthor(Author author){return authorRepository.save(author);}

    // Yazar Silme

    public void deleteAuthor(Long id){
        if(authorRepository.findById(id) != null){
            authorRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Author not found with id: " +id);
        }
    }

    public List<Book> findBooksByAuthorId(Long authorId){
        return authorRepository.findBooksByAuthorId(authorId);
    }


}
