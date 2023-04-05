package com.umc.week.trip.dto;

import com.umc.week.atraction.entity.Atraction;
import com.umc.week.trip.entity.Trip;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class TripCreateRequest {

    private String memberId;

    private String atraction;

//    private List<String> atractionList;

    public Trip toEntity(){
        return Trip.builder()

                .memberId(memberId)
                .tripDate(LocalDate.now().plusDays(1))
//                .atractionList(atractionList)
                .build();
    }
}
