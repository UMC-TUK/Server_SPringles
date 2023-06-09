package com.umc.board.src.controller;

import com.umc.board.config.security.jwt.JwtToken;
import com.umc.board.src.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
    AuthService authService;

    @GetMapping("/refresh")
    public ResponseEntity<JwtToken> authorize(
            @CookieValue(value = "Refresh") String refreshToken,
            @CookieValue(value = "Access") String accessToken) {
        return ResponseEntity.ok(authService.refreshToken(refreshToken, accessToken));
    }
}
