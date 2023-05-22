package com.umc.week.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductPageDto<T> {

    private final List<T> content;
    private final PageInfo pageInfo;

}
