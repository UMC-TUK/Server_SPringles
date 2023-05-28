package com.umc.board.src.service;

import com.umc.board.config.security.jwt.JwtToken;
import com.umc.board.config.security.jwt.JwtTokenProvider;
import com.umc.board.config.security.jwt.JwtValidator;
import com.umc.board.config.security.oauth.user.UserDetailsImpl;
import com.umc.board.src.dao.MemberQueryRepository;
import com.umc.board.src.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberQueryRepository memberQueryRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtValidator jwtValidator;

    @Transactional
    public JwtToken refreshToken(String oldRefreshToken, String oldAccessToken) {
        if (!StringUtils.hasText(oldRefreshToken) || !StringUtils.hasText(oldAccessToken)) {
            throw new IllegalArgumentException();
        }

        if (!jwtTokenProvider.validateToken(oldRefreshToken)) {
            throw new IllegalStateException();
        }

        Authentication authentication = jwtValidator.getAuthentication(oldAccessToken);
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        UUID id = UUID.fromString(user.getName());

        String savedToken = memberQueryRepository.findRefreshTokenById(id);

        if (!savedToken.equals(oldRefreshToken)) {
            throw new IllegalStateException();
        }

        JwtToken jwtToken = jwtTokenProvider.createToken(user);

        Member member = user.getMember();
        member.updateRefreshToken(jwtToken.getRefreshToken());

        return jwtToken;
    }

    public Member getLoginUser() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .getMember();
    }
}
