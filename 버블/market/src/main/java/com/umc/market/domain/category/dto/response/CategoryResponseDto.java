package com.umc.market.domain.category.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CategoryResponseDto {

//    private Long id;

    private UUID categoryUUID;

    private String name;

    private String createdDate;

    private String modifiedDate;

}

