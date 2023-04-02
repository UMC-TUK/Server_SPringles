package com.umc.trip.trip.service;

import com.umc.trip.attraction.entity.Attraction;
import com.umc.trip.attraction.service.AttractionService;
import com.umc.trip.global.IdResponse;
import com.umc.trip.trip.dto.request.TripRequest;
import com.umc.trip.trip.dto.response.TripResponse;
import com.umc.trip.trip.entity.Trip;
import com.umc.trip.trip.entity.TripAttraction;
import com.umc.trip.trip.mapper.TripMapper;
import com.umc.trip.trip.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;
    private final AttractionService attractionService;

    @Transactional
    public IdResponse<Long> saveTrip(TripRequest tripRequest) {
        List<Attraction> attractions = attractionService.getAttractions(tripRequest.getAttractionNames());
        Trip trip = tripMapper.toEntity(tripRequest, attractions);

        return new IdResponse<>(tripRepository.save(trip).getId());
    }

    public TripResponse getTrip(Long id) {
        return tripMapper.toResponse(getEntity(id));
    }

    public List<TripResponse> getTripList() {
        return tripRepository.findAll().stream()
                .map(tripMapper::toResponse)
                .toList();
    }

    private Trip getEntity(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
