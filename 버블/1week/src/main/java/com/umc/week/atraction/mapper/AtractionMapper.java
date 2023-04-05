package com.umc.week.atraction.mapper;

import com.umc.week.atraction.dto.AtractionRequest;
import com.umc.week.atraction.dto.AtractionResponse;
import com.umc.week.atraction.entity.Atraction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AtractionMapper {

    public Atraction toEntity(AtractionRequest atractionRequest){
        return Atraction.builder()
                .place(atractionRequest.getPlace())
                .address(atractionRequest.getAddress())
                .weather(atractionRequest.getWeather())
                .build();
    }

    public AtractionResponse fromEntity(Atraction atraction){
        return AtractionResponse.builder()
                .id(atraction.getId())
                .place(atraction.getPlace())
                .address(atraction.getAddress())
                .weather(atraction.getWeather())
                .build();
    }

}
