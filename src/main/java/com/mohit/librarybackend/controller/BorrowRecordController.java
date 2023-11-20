package com.mohit.librarybackend.controller;

import com.mohit.librarybackend.model.BorrowRecord;
import com.mohit.librarybackend.service.BorrowRecordService;
import com.mohit.librarybackend.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
@CrossOrigin
public class BorrowRecordController {
    @Autowired
    private BorrowRecordService borrowRecordService;
    private SortService sortService;
@PostMapping("/borrowBook")
    public BorrowRecord borrowBook(@RequestBody BorrowRecord borrowRecord){
    return borrowRecordService.borrowBook(borrowRecord);
}
@GetMapping("/record")
public List<BorrowRecord> getAllRecord(){
    return borrowRecordService.getAllBorrowRecords();
}
@GetMapping("/record/{recordId}")
    public BorrowRecord getBorrowRecordById(@PathVariable Long recordId){
    return borrowRecordService.getBorrowRecordById(recordId);
}

@PostMapping("/return/{recordId}")
    public BorrowRecord returnBook(@PathVariable Long recordId){
    return borrowRecordService.returnBook(recordId);
}
@GetMapping("/api/borrow")
public ResponseEntity<List<BorrowRecord>> getAllUsersSorted(@RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {
    List<BorrowRecord> users = sortService.getAllEntitiesSorted(sortBy, BorrowRecord.class);
    return new ResponseEntity<>(users, HttpStatus.OK);

}
}
