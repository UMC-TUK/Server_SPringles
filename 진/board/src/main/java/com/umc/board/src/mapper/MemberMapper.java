package com.umc.board.src.mapper;

import com.umc.board.src.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member toEntity(String githubId) {
        return Member.builder()
                .githubId(githubId)
                .build();
    }
}
