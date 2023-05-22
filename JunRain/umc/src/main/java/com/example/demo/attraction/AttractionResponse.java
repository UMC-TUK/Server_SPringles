package com.example.demo.attraction;

import com.example.demo.trip.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionResponse {

    private String name;
    private String season;
    private String address;

    public AttractionResponse(Attraction attraction) {
        this.name = attraction.getName();
        this.season = attraction.getSeason();
        this.address = attraction.getAddress();
    }
}
