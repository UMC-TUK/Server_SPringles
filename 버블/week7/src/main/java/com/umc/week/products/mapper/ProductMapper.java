package com.umc.week.products.mapper;


import com.umc.week.category.entity.Categorys;
import com.umc.week.products.dto.request.ProductRequestDto;
import com.umc.week.products.dto.response.ProductInfo;
import com.umc.week.products.dto.response.ProductResponseDto;
import com.umc.week.products.entity.Products;
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
                .productUuid(UUID.randomUUID())
                .categorys(categorys)               // 카테고리!
                .description(productRequestDto.getDescription())
                .price(productRequestDto.getPrice())
                .productState(productRequestDto.getProductState())
                .build();
    }

    public ProductResponseDto fromEntity(Products products){
        return ProductResponseDto.builder()
                .productUuid(products.getProductUuid())
                .categoryUuid(products.getCategorys().getCategoryUuid())   //카테고리!
                .categoryName(products.getCategorys().getName())  // 카테고리 !
                .title(products.getTitle())
                .description(products.getDescription())
                .price(products.getPrice())
                .productState(products.getProductState())
                .views(products.getViews())
                .build();
    }

    public ProductInfo fromListEntity(Products products){
        return ProductInfo.builder()
              .title(products.getTitle())
              .price(products.getPrice())
              .productState(products.getProductState())
              .build();
    }

}
