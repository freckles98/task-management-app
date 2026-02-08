package com.chelseavancoller.backend.service;

import com.chelseavancoller.backend.dto.AuthenticationResponse;
import com.chelseavancoller.backend.dto.AuthenticationRequest;
import com.chelseavancoller.backend.dto.RegisterRequest;
import com.chelseavancoller.backend.models.User;
import com.chelseavancoller.backend.repository.UserRepository;
import com.chelseavancoller.backend.security.JwtUtils;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtUtils jwtUtils,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        var user = new User();
        user.setUsername(request.getUsername());
        // IMPORTANT: We encode the password before saving!
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        var jwtToken = jwtUtils.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // This does the heavy lifting: checks username and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        // If we get here, the user is valid. Generate a token.
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtUtils.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}