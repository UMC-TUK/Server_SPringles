package com.example.trip.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;

    public Long saveTrip(TripRequest tripRequest) {
        return tripRepository.save(tripRequest.toEntity()).getId();
    }

    public Optional<Trip> getTrip(Long id) {
        return tripRepository.findById(id);
    }

    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Trip updateTrip(Long id, TripRequest trip) {
        Trip tmp  = getTrip(id).get();
        tmp.setAttractions(trip.getAttractions());
        tmp.setMemberId(trip.getMemberId());
        return tripRepository.save(tmp);
    }
}
