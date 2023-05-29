package com.umc.market.domain.product.repository;

import com.umc.market.domain.product.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Products, Long> {

    Products findByProductUUID(UUID productUUID) ;

    Page<Products> findAllByIsDeletedFalse(Pageable pageable);

}

