package com.umc.trip.attraction.mapper;

import com.umc.trip.attraction.dto.request.AttractionRequest;
import com.umc.trip.attraction.entity.Attraction;
import org.springframework.stereotype.Component;

@Component
public class AttractionMapper {
    public Attraction toEntity(AttractionRequest request) {
        return Attraction.builder()
                .name(request.getName())
                .address(request.getAddress())
                .season(request.getSeason())
                .build();
    }
}
