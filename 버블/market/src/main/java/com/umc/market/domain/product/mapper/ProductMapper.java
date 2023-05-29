package com.umc.market.domain.product.mapper;

import com.umc.market.domain.category.entity.Categorys;
import com.umc.market.domain.product.dto.request.ProductRequestDto;
import com.umc.market.domain.product.dto.response.ProductInfoDto;
import com.umc.market.domain.product.dto.response.ProductResponseDto;
import com.umc.market.domain.product.entity.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Products toEntity(ProductRequestDto productRequestDto, Categorys categorys){
        return Products.builder()
//                .users(users)
                .title(productRequestDto.getTitle())
                .productUUID(UUID.randomUUID())
                .categorys(categorys)               // 카테고리!
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
//                .productState(productRequestDto.getProductState())
                .build();
    }

    public ProductResponseDto fromEntity(Products products){
        return ProductResponseDto.builder()
                .productUUID(products.getProductUUID())
                .categoryName(products.getCategorys().getName())  // 카테고리 !
                .title(products.getTitle())
                .description(products.getDescription())
                .price(products.getPrice())
                .productState(products.getProductState())
                .views(products.getViews())
                .createdDate(products.getCreatedDate())
                .modifiedDate(products.getModifiedDate())
                .build();
    }

    public ProductInfoDto fromListEntity(Products products){
        return ProductInfoDto.builder()
                .title(products.getTitle())
                .price(products.getPrice())
                .productState(products.getProductState())
                .build();
    }


    public void updateProductFromDto(Products product, ProductRequestDto productRequestDto, Categorys categorys) {
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        product.setPrice(productRequestDto.getPrice());
        product.setCategorys(categorys);
    }

}
