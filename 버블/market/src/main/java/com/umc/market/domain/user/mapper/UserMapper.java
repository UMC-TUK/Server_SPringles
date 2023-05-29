package com.umc.market.domain.user.mapper;

import com.umc.market.domain.user.dto.request.UserSignUpRequestDto;
import com.umc.market.domain.user.dto.response.UserResponseDto;
import com.umc.market.domain.user.entity.Role;
import com.umc.market.domain.user.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public Users toEntity(UserSignUpRequestDto userSignUpRequestDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(userSignUpRequestDto.getBirthday()+" 00:00:00.000", formatter);

        return Users.builder()
                .userUUID(UUID.randomUUID())
                .email(userSignUpRequestDto.getEmail())
                .password(userSignUpRequestDto.getPassword())
                .name(userSignUpRequestDto.getName())
                .birthday(dateTime)
                .role(Role.USER)
                .build();
    }


    public UserResponseDto fromEntity(Users users) {
        return UserResponseDto.builder()
                .userUUID(users.getUserUUID())
                .email(users.getEmail())
                .password(users.getPassword())
                .name(users.getName())
                .birthDay(users.getBirthday())
                .createdDate(users.getCreatedDate())
                .modifiedDate(users.getModifiedDate())
                .build();
    }

}
