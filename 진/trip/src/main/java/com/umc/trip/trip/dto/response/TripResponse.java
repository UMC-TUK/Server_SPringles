package com.umc.trip.trip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TripResponse {
    private Long id;
    private String memberId;
    private List<String> attractionNames;
    private LocalDate tripDate;
}
