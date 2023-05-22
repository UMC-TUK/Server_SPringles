package com.umc.board.config.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtValidator jwtValidator;
    @Value("${app.auth.token.auth-header}")
    private String tokenTag;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> token = Optional.ofNullable(parseBearerToken(request));

        token.ifPresent(
                t -> {
                    Authentication authentication = jwtValidator.getAuthentication(t);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                });

        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(tokenTag);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) { // todo 헤더에서 Access 값 조회 시도
            return bearerToken.substring(7);
        }

        Optional<Cookie> cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals("Access")).findFirst(); // todo 쿠키에서 Access 값 조회 시도

        return cookie.map(Cookie::getValue).orElse(null);
    }
}
