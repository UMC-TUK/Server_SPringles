package com.umc.market.global.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TokenInfo {

    private String grantType; // JWT 대한 인증 타입, 여기서는 Bearer를 사용, 이후 HTTP 헤더에 prefix로 붙여주는 타입
    private String accessToken;
    private String refreshToken;
}
