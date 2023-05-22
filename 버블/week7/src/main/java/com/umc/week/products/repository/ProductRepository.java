package com.umc.week.products.repository;

import com.umc.week.products.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Products, Long> {

//    Products findByProductUuid(UUID productUuid) ;

    @Query(value = "SELECT * FROM products WHERE is_deleted is false ", nativeQuery = true)
    Page<Products> findAllProductsWithPagination (Pageable pageable);

}
