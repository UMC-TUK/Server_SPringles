package com.example.trip.attraction;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attraction {
    @Id @GeneratedValue
    private Long Id;
    private String attractionName;
    private String attractionAddress;
    private String season;

    @Builder
    public Attraction(String attractionName, String attractionAddress, String season){
        this.attractionName = attractionName;
        this.attractionAddress = attractionAddress;
        this.season = season;
    }
}
