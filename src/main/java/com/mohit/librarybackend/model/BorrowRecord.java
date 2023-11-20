package com.mohit.librarybackend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user.id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book.id")
    private Book book;
    private Date borrowingDate;
    private Date dueDate;
    private Date returnDate;

    public BorrowRecord(User user, Book book, Date borrowingDate, Date dueDate, Date returnDate) {
        this.user = user;
        this.book = book;
        this.borrowingDate = borrowingDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }


    public BorrowRecord() {

    }
}
