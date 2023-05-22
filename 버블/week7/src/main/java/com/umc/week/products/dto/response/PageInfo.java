package com.umc.week.products.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfo {

    private int pageNo;
    private int pageSize;
    private int totalElements;
    private int totalPages;
}
