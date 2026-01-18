package com.example.backend.auth.service;

import com.example.backend.auth.model.User;

public interface AuthService {

    User register(String username, String email, String password);

    User login(String username, String password);

}
