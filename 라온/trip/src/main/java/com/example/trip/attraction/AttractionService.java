package com.example.trip.attraction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AttractionService {
    private final AttractionRepository attractionRepository;

    public Long saveAttraction(AttractionRequest attractionRequest) {
        return attractionRepository.save(attractionRequest.toEntity()).getId();
    }
}
