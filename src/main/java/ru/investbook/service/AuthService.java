package ru.investbook.service;

import lombok.RequiredArgsConstructor; 
import org.springframework.stereotype.Service;
import ru.investbook.dto.LoginRequest;
import ru.investbook.dto.LoginResponse;
import ru.investbook.security.JWTUtil;

@Service
@RequiredArgsConstructor 
public class AuthService {

    private final JWTUtil jwtUtil;

    /**
     * Authenticates a user and generates a JWT token on success.
     */
    public LoginResponse authenticate(LoginRequest request) {
    // Dummy credentials for temporary testing (REPLACE THIS)
    String dummyUsername = "demoUser";
    String dummyPassword = "demoPass";

    if (dummyUsername.equals(request.getUsername()) && dummyPassword.equals(request.getPassword())) {
        String token = jwtUtil.generateToken(request.getUsername());
        return new LoginResponse(token, request.getUsername());
    }

    // ALTERNATIVE FIX: Throw a standard RuntimeException
    throw new RuntimeException("Authentication failed: Invalid credentials.");
}
}