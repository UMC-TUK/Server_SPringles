package com.umc.trip.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IdResponse<T> {
    private T id;
}
