package com.umc.market.domain.user.service;

import com.umc.market.domain.user.dto.request.UserSignUpRequestDto;
import com.umc.market.domain.user.entity.Users;
import com.umc.market.domain.user.mapper.UserMapper;
import com.umc.market.domain.user.repository.UserRepository;
import com.umc.market.global.jwt.JwtTokenProvider;
import com.umc.market.global.jwt.TokenInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {

    public final UserRepository userRepository;

    public final UserMapper userMapper;

    public final PasswordEncoder passwordEncoder;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final JwtTokenProvider jwtTokenProvider;


    @Transactional
    public Users signup(UserSignUpRequestDto userSignUpRequestDto) {
        try {
            // 이메일 중복 확인
            if (userRepository.findByEmail(userSignUpRequestDto.getEmail())) {
                return null;
            } else {
                String password = passwordEncoder.encode(userSignUpRequestDto.getPassword());
                userSignUpRequestDto.setPassword(password);

                return userRepository.save(userMapper.toEntity(userSignUpRequestDto));
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return null;
    }


    @Transactional
    public TokenInfo login(String memberId, String password) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }



}
