package com.example.demo.trip;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripServices tripServices;

    @PostMapping()
    public ResponseEntity<Long> saveTrip(@RequestBody TripRequest tripRequest) {
        return ResponseEntity.ok(tripServices.saveTrip(tripRequest));
    }


    @GetMapping("/details/{id}")
    public ResponseEntity<TripResponse> findTrip(@PathVariable Long id) {
        return ResponseEntity.ok(new TripResponse(tripServices.getTrip(id)));
    }

    @PatchMapping("/details/{id}")
    public ResponseEntity<TripResponse> updateTrip(@PathVariable Long id, @RequestBody TripUpdate tripUpdate) {
        return ResponseEntity.ok(tripServices.updateTrip(tripUpdate, id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TripResponse>> findAllTrip() {
        return ResponseEntity.ok(tripServices.getAllTrip());
    }


}
