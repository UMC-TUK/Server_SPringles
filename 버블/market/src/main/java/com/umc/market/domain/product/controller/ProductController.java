package com.umc.market.domain.product.controller;

import com.umc.market.domain.product.dto.request.ProductRequestDto;
import com.umc.market.domain.product.dto.response.ProductInfoDto;
import com.umc.market.domain.product.dto.response.ProductResponseDto;
import com.umc.market.domain.product.entity.Products;
import com.umc.market.domain.product.exception.ProductNotFoundException;
import com.umc.market.domain.product.mapper.ProductMapper;
import com.umc.market.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;



    // 차후에 세션 추가해서 User 정보 product entity에 저장하기
    @PostMapping
    public ProductResponseDto postProduct(@Validated @RequestBody ProductRequestDto productRequestDto){

        Products product = productService.postProduct(productRequestDto);
        return productMapper.fromEntity(product);
    }



    // 목차 상품 목록 조회 : 제목, 가격, 상태 확인 가능
    @GetMapping("/list")
    public ResponseEntity<List<ProductInfoDto>> getAllProductsListByPagnation(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        List<ProductInfoDto> productsList = productService.getAllProductList(pageNo, pageSize);
        return ResponseEntity.ok(productsList);
    }



    // 상품 게시물 상세 조회
    @GetMapping("/list/{productUUID}")
    public ResponseEntity<ProductResponseDto> getProductAndIncreaseViews(@PathVariable UUID productUUID) {
        ProductResponseDto product = productService.getProductByUUID(productUUID);
        if (product != null) {
            // 조회수 증가
            productService.increaseViewsCount(productUUID);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // 상품 게시물 삭제
    @DeleteMapping("/{productUUID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productUUID) {
        productService.deleteProduct(productUUID);
        return ResponseEntity.ok().build();
    }



    // 상품 게시물 상태 변경
    @PutMapping("/{productUUID}/state")
    public ResponseEntity<Void> updateProductState(
            @PathVariable UUID productUUID,
            @RequestBody Map<String, String> request) {
        String state = request.get("state");

        productService.updateProductState(productUUID, state);
        return ResponseEntity.ok().build();

    }



    // 게시물 수정
    @PutMapping("/{productUUID}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @PathVariable UUID productUUID,
            @RequestBody ProductRequestDto productRequestDto) {
        try {
            ProductResponseDto updatedProduct = productService.updateProduct(productUUID, productRequestDto);
            return ResponseEntity.ok(updatedProduct);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
