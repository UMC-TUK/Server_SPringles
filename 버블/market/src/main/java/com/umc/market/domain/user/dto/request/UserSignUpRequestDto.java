package com.umc.market.domain.user.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Data
@Builder
@AllArgsConstructor
@ToString

public class UserSignUpRequestDto {


    private String email;


    private String password;


    private String name;


    private String birthday;


}
