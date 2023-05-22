package com.example.demo.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TripRequest {
    private String memberId;

    public TripRequest(final Trip trip) {
        this.memberId = trip.getMemberId();
    }

    public Trip toEntity(){
        return Trip.builder().memberId(memberId)
                .tripDate(LocalDate.now().plusDays(1))
                .build();
    }
}
