package com.example.demo.attraction;

import com.example.demo.trip.Trip;
import com.example.demo.trip.TripRepository;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionRequest {
    private String name;
    private String season;
    private String address;
    private Long tripId;

    public Attraction toEntity(Trip trip) {
        return Attraction.builder()
                .name(name)
                .trip(trip)
                .season(this.season)
                .address(this.address).build();
    }

}
