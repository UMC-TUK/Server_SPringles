package com.umc.market.domain.product.service;

import com.umc.market.domain.category.entity.Categorys;
import com.umc.market.domain.category.exception.CategoryNotFoundException;
import com.umc.market.domain.category.repository.CategoryRepository;
import com.umc.market.domain.product.dto.request.ProductRequestDto;
import com.umc.market.domain.product.dto.response.ProductInfoDto;
import com.umc.market.domain.product.dto.response.ProductResponseDto;
import com.umc.market.domain.product.entity.ProductState;
import com.umc.market.domain.product.entity.Products;
import com.umc.market.domain.product.exception.ProductNotFoundException;
import com.umc.market.domain.product.mapper.ProductMapper;
import com.umc.market.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    public final ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    private final ProductMapper productMapper;


    // 상품 게시물 저장
    @Transactional
    public Products postProduct(ProductRequestDto productRequestDto){

        Categorys findcategory = categoryRepository.findByCategoryUUID(productRequestDto.getCategoryUUID());

        Products product = productMapper.toEntity(productRequestDto, findcategory);
        product.setProductState(ProductState.SALE); // ProductState를 "SALE"로 설정

        return productRepository.save(product);
    }


    // 상품 게시물 목록 페이지 전체 조회
    @Transactional(readOnly = true)
    public List<ProductInfoDto> getAllProductList(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Products> productPage = productRepository.findAllByIsDeletedFalse(pageable);
        return productPage.stream()
                .map(productMapper::fromListEntity)
                .collect(Collectors.toList());
    }


    // 상품 게시물 상세 조회
    @Transactional(readOnly = true)
    public ProductResponseDto getProductByUUID(UUID productUUID) {
        Products product = productRepository.findByProductUUID(productUUID);

        if (product != null) {
            return productMapper.fromEntity(product);
        } else {
            throw new ProductNotFoundException("Product not found" + productUUID);
        }
    }


    // 상품 게시물 삭제
    @Transactional
    public void deleteProduct(UUID productUUID) {
        Products products = productRepository.findByProductUUID(productUUID);
        if (products == null) {
            throw new ProductNotFoundException("Product not found" + productUUID);
        }
        products.setIsDeleted(true);
        productRepository.save(products);
    }


    // 게시물 상태 변경
    @Transactional
    public void updateProductState(UUID productUUID, String state) {
        Products products = productRepository.findByProductUUID(productUUID);

        if (products == null) {
            throw new NoSuchElementException("Product not found");
        }

        try {
            ProductState newState = ProductState.valueOf(state);
            products.setProductState(newState);
            productRepository.save(products);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid state value");
        }
    }


    // 게시물 조회수 업데이트
    @Transactional
    public void increaseViewsCount (UUID productUUID) {
        // 게시물 조회
        Products products = productRepository.findByProductUUID(productUUID);

        int views = products.getViews();
        products.setViews(views + 1);

        productRepository.save(products);
    }


    // 게시물 수정
    @Transactional
    public ProductResponseDto updateProduct(UUID productUUID, ProductRequestDto productRequestDto) {
        Products products = productRepository.findByProductUUID(productUUID);

        if (products == null) {
            throw new ProductNotFoundException("Product not found");
        }

        Categorys category = categoryRepository.findByCategoryUUID(productRequestDto.getCategoryUUID());
        if (category == null) {
            throw new CategoryNotFoundException("Category not found");
        }

        productMapper.updateProductFromDto(products, productRequestDto, category);

        Products updatedProduct = productRepository.save(products);
        return productMapper.fromEntity(updatedProduct);
    }


}
