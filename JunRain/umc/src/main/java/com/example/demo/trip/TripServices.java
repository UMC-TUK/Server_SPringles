package com.example.demo.trip;

import com.example.demo.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServices {
    private final TripRepository tripRepository;

    public Long saveTrip(TripRequest tripRequest) {
        return tripRepository.save(tripRequest.toEntity()).getId();
    }

    public Trip getTrip(Long id) {
        Optional<Trip> trip = tripRepository.findById(id);
            if(trip.isPresent()) {
                return trip.get();
            } else {
                throw new DataNotFoundException("Data가 없습니다");
        }
    }

    public List<TripResponse> getAllTrip() {
        // 출력할때 DTO로 변환
        return this.tripRepository.findAll().stream().map(TripResponse::new).collect(Collectors.toList());
    }

    public TripResponse updateTrip(TripUpdate tripUpdate, Long id){
        Trip trip = tripRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Not Data"));
        trip.setMemberId(tripUpdate.getMemberId());
        trip.setTripDate(trip.getTripDate().plusDays(tripUpdate.getDay()));
        tripRepository.save(trip);
        return new TripResponse(trip);
    }
}
