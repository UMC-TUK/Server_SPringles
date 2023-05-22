package com.umc.week.products.dto.request;

import com.umc.week.products.entity.ProductState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private UUID categoryUuid; //

    private String title;

    private String description;

    private int price;

    private ProductState productState;


}
