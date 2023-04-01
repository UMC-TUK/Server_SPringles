package com.example.trip.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {
    private final TripService tripService;

    @PostMapping
    public ResponseEntity<Long> saveTrip(@RequestBody TripRequest tripRequest){
        return ResponseEntity.ok(tripService.saveTrip(tripRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable Long id){
        return ResponseEntity.ok(tripService.getTrip(id).get());
    }

    @GetMapping("all-trips")
    public ResponseEntity<List<Trip>> getAllTrips(){
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id , @RequestBody TripRequest tripRequest){
        return ResponseEntity.ok(tripService.updateTrip(id, tripRequest));
    }
}
