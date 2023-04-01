package com.example.trip.attraction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionRequest {
    private String attractionName;
    private String attractionAddress;
    private String season;

    public Attraction toEntity() {
        return Attraction.builder()
                .attractionAddress(attractionAddress)
                .attractionName(attractionName)
                .season(season)
                .build();
    }
}
