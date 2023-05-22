package com.umc.week.products.dto.response;

import com.umc.week.products.entity.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ProductResponseDto {

//    private Long id;

//    private Long userId;

    private UUID categoryUuid;   //

    private String categoryName;  //

    private UUID productUuid;

    private String title;

    private String description;

    private int price;

    private ProductState productState;

    private int views;



}
