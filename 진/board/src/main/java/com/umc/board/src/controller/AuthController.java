package com.umc.board.src.controller;

import com.umc.board.config.security.jwt.JwtToken;
import com.umc.board.src.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("/refresh")
    public ResponseEntity<JwtToken> authorize(
            @CookieValue(value = "Refresh") String refreshToken,
            @CookieValue(value = "Access") String accessToken) {
        return ResponseEntity.ok(authService.refreshToken(refreshToken, accessToken));
    }
}
