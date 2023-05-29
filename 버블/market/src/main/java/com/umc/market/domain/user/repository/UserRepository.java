package com.umc.market.domain.user.repository;

import com.umc.market.domain.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

//    Optional<Users> findByEmailIsDeletedIsFalse(String email);

    boolean findByEmail(String email);

}
