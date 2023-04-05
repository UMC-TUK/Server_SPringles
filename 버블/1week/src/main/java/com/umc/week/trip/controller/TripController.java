package com.umc.week.trip.controller;

import com.umc.week.trip.dto.TripCreateRequest;
import com.umc.week.trip.dto.TripResponse;
import com.umc.week.trip.entity.Trip;
import com.umc.week.trip.mapper.TripMapper;
import com.umc.week.trip.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    private final TripMapper tripMapper;

//    @PostMapping
//    public ResponseEntity<Long> saveTrip(@RequestBody TripCreateRequest tripCreateRequest){
//        return ResponseEntity.ok(tripService.saveTrip(tripCreateRequest));
//
//    }

    @PostMapping
    public TripResponse addTrip (@Validated @RequestBody TripCreateRequest tripCreateRequest){
        Trip trip = tripService.saveTrip(tripCreateRequest);
        return tripMapper.fromEntity(trip);
    }

    @PatchMapping("/update")
    public Trip updateTrip (@RequestBody Trip requestTrip){
        Trip trip = tripService.update(requestTrip);
        return trip;
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<TripResponse>> getTripList (
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size ) {
//        List<TripResponse> TripList = tripservice.
//    }

}
