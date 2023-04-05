package com.umc.week.trip.dto;

import com.umc.week.trip.entity.Trip;
import lombok.*;
import com.umc.week.atraction.dto.AtractionResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripResponse {

    private Long id;

    private String memberId;

    private LocalDate tripDate;

    private String atraction;

//    private List<AtractionResponse> atraction;

//    public TripResponse(Trip trip) {
//        this.memberId = trip.getMemberId();
//        this.tripDate = trip.getTripDate();
//        this.atraction = trip.atraction();
//
//    }
}
