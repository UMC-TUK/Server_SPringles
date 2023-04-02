package com.example.demo.trip;

import com.example.demo.attraction.Attraction;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
public class Trip {

    @Id @GeneratedValue @Column(name = "TRIP_ID")
    private Long id;
    private String memberId;
    private LocalDate tripDate;

    @OneToMany(mappedBy = "trip")
    private List<Attraction> attractionList = new ArrayList<>();

    @Builder
    public Trip(String memberId, LocalDate tripDate) {
        this.memberId = memberId;
        this.tripDate = tripDate;
    }
}
