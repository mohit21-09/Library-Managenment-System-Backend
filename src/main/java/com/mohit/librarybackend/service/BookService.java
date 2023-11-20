package com.mohit.librarybackend.service;

import com.mohit.librarybackend.model.Book;

import java.util.List;

public interface BookService {
public List<Book> getAllBooks();
public Book getBookById(Long BookId);
public Book addBook(Book book);
public Book updateBook(Long bookId,Book updateBook);
public void deleteBook(Long bookId);
}
