package com.umc.trip.trip.controller;

import com.umc.trip.global.IdResponse;
import com.umc.trip.trip.dto.request.TripRequest;
import com.umc.trip.trip.dto.response.TripResponse;
import com.umc.trip.trip.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> saveTrip(@RequestBody TripRequest tripRequest) {
        return ResponseEntity.ok(tripService.saveTrip(tripRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TripResponse> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTrip(id));
    }

    @GetMapping
    public ResponseEntity<List<TripResponse>> getTripList() {
        return ResponseEntity.ok(tripService.getTripList());
    }
}
