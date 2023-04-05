package com.umc.week.atraction.entity;

import com.umc.week.trip.entity.Trip;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Atraction {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "weather", nullable = false)
    private String weather;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "trip_id")
//    private Trip trip;

    @Builder
    public Atraction(String place, String address, String weather) {
        this.place = place;
        this.address = address;
        this.weather = weather;
    }
}
