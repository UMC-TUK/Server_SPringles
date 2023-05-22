package com.example.usedcar.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UsedCar {
    @Id @GeneratedValue
    private Long id;       //DB id
    private String color;  //색
    private Long mileage;  //주행거리
    private Long price;    //가격
    private String name;   //차종
    private String model_year; //연식

    @Builder
    public UsedCar(String color, Long mileage, Long price, String name, String model_year) {
        this.color = color;
        this.mileage = mileage;
        this.price = price;
        this.name = name;
        this.model_year = model_year;
    }
}
