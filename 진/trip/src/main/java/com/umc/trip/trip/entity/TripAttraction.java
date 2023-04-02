package com.umc.trip.trip.entity;

import com.umc.trip.attraction.entity.Attraction;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TripAttraction {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    public TripAttraction(Attraction attraction, Trip trip) {
        this.attraction = attraction;
        this.trip = trip;
        this.attraction.addTripAttraction(this);
    }
}
