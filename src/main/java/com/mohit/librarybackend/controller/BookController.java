package com.mohit.librarybackend.controller;

import com.mohit.librarybackend.model.Book;
import com.mohit.librarybackend.service.BookService;
import com.mohit.librarybackend.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
@Autowired
    private BookService bookService;
@Autowired
private SortService sortService;
@PostMapping("/addBook")
    public String addBook(@RequestBody Book book){
    bookService.addBook(book);
    return "New Book is added";
}
@PutMapping("/update/{bookId}")
    public  Book updateBook(@PathVariable Long bookId, @RequestBody Book updatedBook){
    return bookService.updateBook(bookId,updatedBook);
}
@GetMapping("/books")
    public List<Book> getAllBooks(){
    return bookService.getAllBooks();
}
@GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId){
    return bookService.getBookById(bookId);
}
@DeleteMapping("/delete/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
    bookService.deleteBook(bookId);
}
    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getAllBooksSorted(@RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {
        List<Book> books = sortService.getAllEntitiesSorted(sortBy, Book.class);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
