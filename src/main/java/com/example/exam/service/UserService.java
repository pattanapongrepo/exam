package com.example.exam.service;

import com.example.exam.entities.User;
import com.example.exam.exception.ResourceNotFoundException;
import com.example.exam.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * @param id of User
     * @return User or Throw ResourceNotFoundException when User null
     */
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found with id = " +id));
    }

}
