package com.ardakavas.LibraryAutomation.service;

import com.ardakavas.LibraryAutomation.model.Book;
import com.ardakavas.LibraryAutomation.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // ID'ye göre kitap getir
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Kitap kaydet
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // ID'ye göre kitap sil
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalExistingBook = bookRepository.findById(id);
        if (optionalExistingBook.isPresent()) {
            Book existingBook = optionalExistingBook.get();
            existingBook.setBook_name(updatedBook.getBook_name());
            existingBook.setAuthor_id(updatedBook.getAuthor_id());
            existingBook.setCategory_id(updatedBook.getCategory_id());
            existingBook.setPublication_year(updatedBook.getPublication_year());
            bookRepository.save(existingBook);
        }
        return optionalExistingBook;
    }
   /* public List<Book> getBooksByCategory(Long categoryId) {
        return bookRepository.findByCategory_Id(categoryId);
    }*/

    // Kitap adına göre kitap getir (Özelleştirilebilir)
    /*public List<Book> getBooksByName(String bookName) {
        return bookRepository.findByBookNameContainingIgnoreCase(bookName);
    }*/

    // Yazar ID'ye göre kitapları getir (Özelleştirilebilir)
    /*public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }*/

    // Kategori ID'ye göre kitapları getir (Özelleştirilebilir)
    public List<Book> getBooksByCategoryId(Long categoryId) {
        return bookRepository.findBooksByCategoryId(categoryId);
    }

    public List<Book> getBooksByAuthorId(Long authorId){
        return bookRepository.findBooksByAuthorId(authorId);
    }
}
