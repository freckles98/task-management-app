package com.example.backend.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.auth.model.LoginRequest;
import com.example.backend.auth.model.LoginResponse;
import com.example.backend.auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    // To do implement JWT Service here

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest) {
        authService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return new LoginResponse("Login successful");// TODO: implement JWT token generation
    }
}
