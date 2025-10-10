package ru.investbook.api;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import ru.investbook.dto.LoginRequest;
import ru.investbook.dto.LoginResponse;
import ru.investbook.service.AuthService;

@RestController
@RequestMapping("/api") // Handling client requests from mobile app
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) { // Constructor injection
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Validate credentials and generate JWT
        LoginResponse response = authService.authenticate(request);

        if (response == null) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }

        return ResponseEntity.ok(response); // Return JWT and user info
    }
}