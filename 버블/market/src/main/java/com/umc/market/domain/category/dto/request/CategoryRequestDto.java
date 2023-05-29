package com.umc.market.domain.category.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {

    @NonNull
    private String name;


}

