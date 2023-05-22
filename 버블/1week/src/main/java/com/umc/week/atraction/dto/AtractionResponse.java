package com.umc.week.atraction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AtractionResponse {

    private Long id;

    private String place;

    private String address;

    private String weather;
}
