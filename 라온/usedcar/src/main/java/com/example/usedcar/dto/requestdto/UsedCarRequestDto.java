package com.example.usedcar.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsedCarRequestDto {
    @NotBlank
    private String color;
    @NotNull
    private Long mileage;
    @NotNull
    private Long price;
    @NotBlank
    private String name;
    @NotBlank
    private String model_year;
}
