package com.mohit.librarybackend.repository;

import com.mohit.librarybackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
