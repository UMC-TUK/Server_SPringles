package com.umc.trip.trip.dto.request;

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
    private List<String> attractionNames;
    private LocalDate tripDate;
}
