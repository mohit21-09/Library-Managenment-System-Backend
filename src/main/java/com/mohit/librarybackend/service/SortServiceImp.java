package com.mohit.librarybackend.service;

import com.mohit.librarybackend.model.Book;
import com.mohit.librarybackend.model.BorrowRecord;
import com.mohit.librarybackend.model.User;
import com.mohit.librarybackend.repository.BookRepository;
import com.mohit.librarybackend.repository.BorrowRecordRepository;
import com.mohit.librarybackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImp implements SortService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public <T> List<T> getAllEntitiesSorted(String sortBy, Class<T> entityType) {
        Sort sort = Sort.by(sortBy);

        if (entityType.equals(Book.class)) {
            return (List<T>) bookRepository.findAll(sort);
        } else if (entityType.equals(User.class)) {
            return (List<T>) userRepository.findAll(sort);
        } else if (entityType.equals(BorrowRecord.class)) {
            return (List<T>) borrowRecordRepository.findAll(sort);
        }

        throw new IllegalArgumentException("Unsupported entity type: " + entityType);
    }
}

