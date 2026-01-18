package com.example.backend.auth.service;

import org.springframework.stereotype.Service;

import com.example.backend.auth.model.User;
import com.example.backend.auth.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(String username, String email, String password) {
        return userRepository.save(new User(username, email, password));
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid login")); // throw custom error
    }

}
