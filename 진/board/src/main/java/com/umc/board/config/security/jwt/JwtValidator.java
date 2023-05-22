package com.umc.board.config.security.jwt;

import com.umc.board.config.security.oauth.user.UserDetailsImpl;
import com.umc.board.config.security.oauth.user.UserDetailsMapper;
import com.umc.board.src.dao.MemberRepository;
import com.umc.board.src.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtValidator {
    private final Key key;
    private final MemberRepository memberRepository;
    private final UserDetailsMapper userDetailsMapper;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getTokenBodyClaims(accessToken);
        Optional<Member> member = memberRepository.findById(extractUUID(claims));
        if (member.isEmpty()) {
            return null;
        }
        UserDetailsImpl loginUser = userDetailsMapper.mapToLoginUser(member.get());

        return new UsernamePasswordAuthenticationToken(loginUser, "", loginUser.getAuthorities());
    }

    private UUID extractUUID(Claims claims) {
        return UUID.fromString(claims.get("id", String.class));
    }

    private Claims getTokenBodyClaims(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }
}
