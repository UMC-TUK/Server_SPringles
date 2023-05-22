package com.example.demo.trip;

import com.example.demo.attraction.Attraction;
import com.example.demo.attraction.AttractionRequest;
import com.example.demo.attraction.AttractionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TripResponse {
    private String memberId;
    private List<AttractionResponse> attractions;
    private LocalDate localDate;

    public TripResponse(Trip trip) {
        this.memberId = trip.getMemberId();
        this.attractions = trip.getAttractionList().stream().map(AttractionResponse::new).collect(Collectors.toList());
        this.localDate = trip.getTripDate();
    }
}
