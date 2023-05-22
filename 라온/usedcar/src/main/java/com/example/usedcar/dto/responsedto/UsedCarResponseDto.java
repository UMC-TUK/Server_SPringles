package com.example.usedcar.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsedCarResponseDto {
    private Long id;
    private String color;
    private Long mileage;
    private Long price;
    private String name;
    private String model_year;
}
