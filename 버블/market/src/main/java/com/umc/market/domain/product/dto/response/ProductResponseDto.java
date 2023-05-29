package com.umc.market.domain.product.dto.response;

import com.umc.market.domain.product.entity.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ProductResponseDto {

//    private UUID categoryUuid;

    private String categoryName;

    private UUID productUUID;

    private String title;

    private String description;

    private int price;

    private ProductState productState;

    private int views;

    private String createdDate;

    private String modifiedDate;


}

