package com.example.trip.trip;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TripRequest {
    private String memberId;
    private List<String> attractions;

    public Trip toEntity() {
        return Trip.builder()
                .memberId(memberId)
                .tripDate(LocalDate.now().plusDays(1))
                .attractions(attractions)
                .build();
    }
}
