package com.umc.week.atraction.repository;

import com.umc.week.atraction.entity.Atraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtractionRepository extends JpaRepository<Atraction, Long> {
}
