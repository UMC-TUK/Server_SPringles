package com.umc.week.trip.entity;

import com.umc.week.atraction.entity.Atraction;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name = "memberId", nullable = false)
    private  String memberId;

    @Column(name = "atraction", nullable = false)
    private String atraction;

    @Column(name = "tripDate", nullable = false)
    private LocalDate tripDate;

    @Builder
    public Trip(String memberId, LocalDate tripDate, String atraction) {
        this.memberId = memberId;
        this.tripDate = tripDate;
        this.atraction = atraction;
    }

    //    @OneToMany(mappedBy = "trip")
//    private List<Atraction> atractionList = new ArrayList<>();

    public void update(Trip updateTrip){
        this.id = updateTrip.getId();
        this.memberId = updateTrip.getMemberId();
        this.atraction = updateTrip.getAtraction();
    }

    //    public Trip(String memberId, LocalDate tripDate, List<String> atractionList) {
//        this.memberId = memberId;
//        this.tripDate = tripDate;
//        this.atractionList = atractionList;
//    }

    // 수정 -> 관광지만 수정

}
