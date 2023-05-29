package com.umc.market.domain.category.dto.request;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryUpdateDto {

    @NonNull
    private String name;
}
