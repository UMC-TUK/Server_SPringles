package com.umc.week.products.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductState {
    // 판매중, 예약중, 판매완료
    SALE,
    RESERVED,
    SOLD,

};
