package com.mohit.librarybackend.service;

import com.mohit.librarybackend.model.BorrowRecord;
import com.mohit.librarybackend.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowRecordServiceImp implements BorrowRecordService{
    @Autowired
    private BorrowRecordRepository borrowRecordRepository;
    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
return borrowRecordRepository.findAll();
    }

    @Override
    public BorrowRecord getBorrowRecordById(Long recordId) {
        return borrowRecordRepository.findById(recordId).orElse(null);
    }

    @Override
    public BorrowRecord borrowBook(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);

    }

    @Override
    public BorrowRecord returnBook(Long recordId) {
        if(borrowRecordRepository.existsById(recordId)){
            return borrowRecordRepository.findById(recordId).orElse(null);
        }
        return null;
    }
}
