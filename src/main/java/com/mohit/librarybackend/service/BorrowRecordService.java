package com.mohit.librarybackend.service;

import com.mohit.librarybackend.model.BorrowRecord;

import java.util.List;

public interface BorrowRecordService {

    public List<BorrowRecord> getAllBorrowRecords();
    public BorrowRecord getBorrowRecordById(Long recordId);
    public BorrowRecord borrowBook(BorrowRecord borrowRecord);
    public BorrowRecord returnBook(Long recordId);

}
