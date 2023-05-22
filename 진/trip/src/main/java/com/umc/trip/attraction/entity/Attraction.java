package com.umc.trip.attraction.entity;

import com.umc.trip.trip.entity.TripAttraction;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attraction {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String address;

    @Enumerated(EnumType.STRING)
    private Season season;

    @OneToMany(mappedBy = "attraction", cascade = CascadeType.ALL)
    private List<TripAttraction> tripAttractions = new ArrayList<>();

    @Builder
    public Attraction(String name, String address, Season season) {
        this.name = name;
        this.address = address;
        this.season = season;
    }

    public void update(String name, String address, Season season) {
        this.name = name;
        this.address = address;
        this.season = season;
    }

    public void addTripAttraction(TripAttraction tripAttraction) {
        this.tripAttractions.add(tripAttraction);
    }
}
