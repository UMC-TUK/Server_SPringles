package com.umc.market.domain.user.controller;

import com.umc.market.domain.user.dto.request.UserLoginRequestDto;
import com.umc.market.domain.user.dto.request.UserSignUpRequestDto;
import com.umc.market.domain.user.entity.Users;
import com.umc.market.domain.user.mapper.UserMapper;
import com.umc.market.domain.user.service.UserService;
import com.umc.market.global.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@ModelAttribute  UserSignUpRequestDto userSignUpRequestDto, Errors errors) {
        // validation check
        if(errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please check your value");
        }
        // 객체가 null인 경우 에러 코드 404 return
        if (userSignUpRequestDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Please enter your information");
        }
        Users users = userService.signup(userSignUpRequestDto);

        // 이메일이 중복될 경우 에러 코드 409 return
        if(users == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("The email is duplicated. Please check your email.");
        }
        return ResponseEntity.ok(userMapper.fromEntity(users));
    }



    @PostMapping("/login")
    public TokenInfo login(@ModelAttribute @Validated UserLoginRequestDto userLoginRequestDto) {
        String memberId = userLoginRequestDto.getEmail();
        String password = userLoginRequestDto.getPassword();
        TokenInfo tokenInfo = userService.login(memberId, password);
        return tokenInfo;
    }


}
