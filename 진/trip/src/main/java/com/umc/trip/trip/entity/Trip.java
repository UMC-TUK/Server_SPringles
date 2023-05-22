package com.umc.trip.trip.entity;

import com.umc.trip.attraction.entity.Attraction;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Trip {
    @Id @GeneratedValue
    private Long id;
    private String memberId;
    private LocalDate tripDate;
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<TripAttraction> tripAttractions = new ArrayList<>();

    @Builder
    public Trip(String memberId, LocalDate tripDate, List<Attraction> attractions) {
        this.memberId = memberId;
        this.tripDate = tripDate;
        organizeTripAttractions(attractions);
    }

    public void organizeTripAttractions(List<Attraction> attractions) {
        this.tripAttractions.addAll(attractions.stream().map(attraction -> new TripAttraction(attraction, this)).toList());
    }
}
