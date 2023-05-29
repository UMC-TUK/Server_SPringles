package com.umc.board.src.dao;

import com.umc.board.src.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID>, MemberQueryRepository {
    @Transactional
    @Modifying
    @Query("UPDATE Member m SET m.refreshToken = :token WHERE m.id = :id")
    void updateRefreshToken(UUID id, String token);

    @Query("SELECT m.refreshToken FROM Member m WHERE m.id = :id")
    String findRefreshTokenById(UUID id);
}
