package com.umc.week.category.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CategoryResponseDto {


    private UUID categoryUuid;

    private String name;

    private String createdDate;

    private String modifiedDate;


}
