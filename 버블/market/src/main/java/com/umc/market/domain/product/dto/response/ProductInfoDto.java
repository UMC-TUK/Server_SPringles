package com.umc.market.domain.product.dto.response;

import com.umc.market.domain.product.entity.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ProductInfoDto {

    private String title;

    private int price;

//    private final String description;

    private ProductState productState;


}

