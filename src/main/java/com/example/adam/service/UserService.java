package com.example.adam.service;

import com.example.adam.model.User;
import com.example.adam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String userEmail) {
        // Use the userRepository to fetch the user by email
        return userRepository.findByEmail(userEmail);
    }

    // Rest of the service code...
}