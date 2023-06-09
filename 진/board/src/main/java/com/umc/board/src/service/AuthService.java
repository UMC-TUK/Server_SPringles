package com.umc.board.src.service;

import com.umc.board.config.security.jwt.JwtToken;
import com.umc.board.config.security.jwt.JwtTokenProvider;
import com.umc.board.config.security.jwt.JwtValidator;
import com.umc.board.config.security.oauth.user.UserDetailsImpl;
import com.umc.board.src.dao.MemberRepository;
import com.umc.board.src.entity.Member;
import com.umc.board.src.exception.InvalidJwtException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthService {
    MemberRepository memberRepository;
    JwtTokenProvider jwtTokenProvider;
    JwtValidator jwtValidator;

    @Transactional
    public JwtToken refreshToken(String oldRefreshToken, String oldAccessToken) {
        if (!StringUtils.hasText(oldRefreshToken) || !StringUtils.hasText(oldAccessToken)) {
            throw new InvalidJwtException();
        }

        if (!jwtTokenProvider.validateToken(oldRefreshToken)) throw new InvalidJwtException();

        Authentication authentication = jwtValidator.getAuthentication(oldAccessToken);
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        UUID id = UUID.fromString(user.getName());

        String savedToken = memberRepository.findRefreshTokenById(id);

        if (!savedToken.equals(oldRefreshToken)) throw new InvalidJwtException();

        JwtToken jwtToken = jwtTokenProvider.createToken(user);

        Member member = user.getMember();
        member.updateRefreshToken(jwtToken.getRefreshToken());

        return jwtToken;
    }
}
