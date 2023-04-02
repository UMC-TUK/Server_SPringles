package com.umc.trip.attraction.dto.request;

import com.umc.trip.attraction.entity.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AttractionRequest {
    private String name;
    private String address;
    private Season season;
}
