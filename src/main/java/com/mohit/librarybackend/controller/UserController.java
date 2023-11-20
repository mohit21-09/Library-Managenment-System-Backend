package com.mohit.librarybackend.controller;

import com.mohit.librarybackend.model.User;
import com.mohit.librarybackend.service.SortService;
import com.mohit.librarybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    private SortService sortService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
    @GetMapping("/user/all")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }
    @PutMapping("/user/update/{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User user){
        return userService.updateUser(userId,user);
    }
    @DeleteMapping("/user/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

    @GetMapping("/api/user")
    public ResponseEntity<List<User>> getAllUsersSorted(@RequestParam(value = "sortBy", defaultValue = "id") String sortBy) {
        List<User> users = sortService.getAllEntitiesSorted(sortBy, User.class);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
}
