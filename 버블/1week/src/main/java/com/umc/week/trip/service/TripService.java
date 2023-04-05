package com.umc.week.trip.service;

import com.umc.week.atraction.mapper.AtractionMapper;
import com.umc.week.trip.dto.TripResponse;
import com.umc.week.trip.entity.Trip;
import com.umc.week.trip.mapper.TripMapper;
import com.umc.week.trip.repository.TripRepository;
import com.umc.week.trip.dto.TripCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class TripService {
    private final TripRepository tripRepository;

    public final TripMapper tripMapper;

    @Transactional
    public Trip saveTrip(TripCreateRequest tripCreateRequest) {
        return tripRepository.save(tripMapper.toEntity(tripCreateRequest));
    }


    @Transactional
    public Trip update(Trip updateTrip){
        Trip existingTrip = tripRepository.findById(updateTrip.getId())
                .orElseThrow(()-> new RuntimeException("여행일정을 찾을 수 없습니다"));
        existingTrip.update(updateTrip);
        return tripRepository.save(existingTrip);
    }

//    @Transactional(readOnly = true)
//    public List<TripResponse> getTripList(int page, int size){
//        PageRequest pageRequest = PageRequest.of(page,size);
//        return tripRepository.findTripWithPagination(pageRequest).stream()
//                .map(this::mapTripE)
//                .collect(Collectors.toList());
//    }

}
