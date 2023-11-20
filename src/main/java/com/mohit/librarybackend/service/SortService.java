package com.mohit.librarybackend.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface SortService {
    public <T> List<T> getAllEntitiesSorted(String sortBy, Class<T> entityType) ;
}
