package com.umc.market.global.common;

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
