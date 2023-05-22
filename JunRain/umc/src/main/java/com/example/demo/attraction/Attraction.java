package com.example.demo.attraction;

import com.example.demo.trip.Trip;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Builder
public final class Attraction {

    @Id
    @GeneratedValue
    @Column(name = "Attraction_ID")
    private Long id;
    private String name;
    private String address;
    private String season;

    @ManyToOne
    @JoinColumn(name = "TRIP_ID")
    private Trip trip;

//    public void addList(Trip trip) {
//        this.trip = trip;
//        trip.getAttractionList().add(this);
//    }

}


