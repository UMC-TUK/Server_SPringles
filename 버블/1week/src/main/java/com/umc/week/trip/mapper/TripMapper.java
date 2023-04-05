package com.umc.week.trip.mapper;

import com.umc.week.trip.dto.TripCreateRequest;
import com.umc.week.trip.dto.TripResponse;
import com.umc.week.trip.entity.Trip;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TripMapper {
    public Trip toEntity(TripCreateRequest tripCreateRequest){
        return Trip.builder()
                .memberId(tripCreateRequest.getMemberId())
                .atraction(tripCreateRequest.getAtraction())
                .tripDate(LocalDate.now().plusDays(1))
//                .atractionList(tripCreateRequest.getAtractionList())
                .build();
    }

    public TripResponse fromEntity(Trip trip) {
        return TripResponse.builder()
                .id(trip.getId())
                .memberId(trip.getMemberId())
                .atraction(trip.getAtraction())
                .tripDate(trip.getTripDate())
//                .atractionList(trip.getAtractionList())
                .build();
    }
}
