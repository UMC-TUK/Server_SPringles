package com.example.demo.attraction;

import com.example.demo.DataNotFoundException;
import com.example.demo.trip.Trip;
import com.example.demo.trip.TripRepository;
import com.example.demo.trip.TripServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttractionService {

    private final AttractionRepository attractionRepository;
    private final TripRepository tripRepository;

    public Long saveAttraction(AttractionRequest attractionRequest) {
        Optional<Trip> trip = tripRepository.findById(attractionRequest.getTripId());
        if(trip.isPresent()) {
            return attractionRepository.save(attractionRequest.toEntity(trip.get())).getId();
        } else throw new DataNotFoundException("NoDATA");
    }


}
