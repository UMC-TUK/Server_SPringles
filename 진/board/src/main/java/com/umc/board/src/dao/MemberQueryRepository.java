package com.umc.board.src.dao;

import com.umc.board.src.entity.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

public interface MemberQueryRepository {
    Optional<Member> findMemberByGithubId(String githubId);
    void updateRefreshToken(UUID id, String token);
    String findRefreshTokenById(UUID id);
}
