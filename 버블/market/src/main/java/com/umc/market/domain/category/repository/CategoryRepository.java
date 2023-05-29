package com.umc.market.domain.category.repository;

import com.umc.market.domain.category.entity.Categorys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Categorys, Long> {
    Categorys findByCategoryUUID(UUID categoryUUID);
    List<Categorys> findAllByIsDeletedFalse();


}
