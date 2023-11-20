package com.mohit.librarybackend.service;

import com.mohit.librarybackend.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long userId);
    public User registerUser(User user);
    public User updateUser(Long userId,User updateUser);
    public void deleteUser(Long userId);
}
