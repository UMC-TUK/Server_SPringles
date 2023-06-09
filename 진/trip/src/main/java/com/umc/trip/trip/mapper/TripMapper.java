package com.umc.trip.trip.mapper;

import com.umc.trip.attraction.entity.Attraction;
import com.umc.trip.trip.dto.request.TripRequest;
import com.umc.trip.trip.dto.response.TripResponse;
import com.umc.trip.trip.entity.Trip;
import com.umc.trip.trip.entity.TripAttraction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TripMapper {
    public Trip toEntity(TripRequest request, List<Attraction> attractions) {
        return Trip.builder()
                .memberId(request.getMemberId())
                .tripDate(request.getTripDate())
                .attractions(attractions)
                .build();
    }

    public TripResponse toResponse(Trip entity) {
        return TripResponse.builder()
                .id(entity.getId())
                .memberId(entity.getMemberId())
                .tripDate(entity.getTripDate())
                .attractionNames(toAttractionNames(entity.getTripAttractions()))
                .build();
    }

    public List<String> toAttractionNames(List<TripAttraction> attractions) {
        return attractions.stream()
                .map(TripAttraction::getAttraction)
                .map(Attraction::getName)
                .toList();
    }
}
