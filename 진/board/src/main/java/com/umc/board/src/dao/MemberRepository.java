package com.umc.board.src.dao;

import com.umc.board.src.entity.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {
    Optional<Member> findMemberByGithubId(String githubId);
    void updateRefreshToken(UUID id, String token);
    String findRefreshTokenById(UUID id);
    Member save(Member member);
    Optional<Member> findById(UUID id);
}
