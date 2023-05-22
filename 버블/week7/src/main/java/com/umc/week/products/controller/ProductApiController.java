package com.umc.week.products.controller;

import com.umc.week.products.dto.request.ProductRequestDto;
import com.umc.week.products.dto.response.ProductInfo;
import com.umc.week.products.dto.response.ProductResponseDto;
import com.umc.week.products.entity.Products;
import com.umc.week.products.mapper.ProductMapper;
import com.umc.week.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductApiController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    // 차후에 세션 추가해서 User 정보 product entity에 저장하기
    @PostMapping
    public ProductResponseDto postProduct(@Validated @RequestBody ProductRequestDto productRequestDto){

        Products product = productService.postProduct(productRequestDto);
        return productMapper.fromEntity(product);
    }

    // 목차 상품 목록 : 제목, 가격, 상태 확인 가능
    @GetMapping("/list")
    public ResponseEntity<List<ProductInfo>> getAllProductsListByPagnation(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<ProductInfo> productsList = productService.getAllProductList(pageNo, pageSize);
        return ResponseEntity.ok(productsList);
    }
}
