package com.example.exam.controller;

import com.example.exam.entities.User;
import com.example.exam.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
    
    public static void main(String[] args){

        
    }
}
