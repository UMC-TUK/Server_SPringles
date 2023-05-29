package com.umc.market.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private UUID userUUID;

    private String email;

    private String password;

    private String name;

    private LocalDateTime birthDay;

    private String createdDate;

    private String modifiedDate;

}

