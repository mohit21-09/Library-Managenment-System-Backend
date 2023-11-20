package com.mohit.librarybackend.service;

import com.mohit.librarybackend.model.Book;
import com.mohit.librarybackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImp implements BookService {
@Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long BookId) {
        return bookRepository.findById(BookId).orElse(null);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, Book updatedBook) {
        if(bookRepository.existsById(bookId)){
            updatedBook.setId(bookId);
            return bookRepository.save(updatedBook);
        }
        return null;
    }
    @Override
    public void deleteBook(Long bookId) {
        if(bookRepository.existsById(bookId)){
            bookRepository.deleteById(bookId);
        }
    }
}
