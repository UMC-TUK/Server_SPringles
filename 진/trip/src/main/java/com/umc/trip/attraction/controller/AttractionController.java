package com.umc.trip.attraction.controller;

import com.umc.trip.attraction.dto.request.AttractionRequest;
import com.umc.trip.attraction.service.AttractionService;
import com.umc.trip.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    @PostMapping
    public ResponseEntity<IdResponse<Long>> saveAttraction(@RequestBody AttractionRequest attractionRequest) {
        return ResponseEntity.ok(attractionService.saveAttraction(attractionRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putAttraction(@RequestBody AttractionRequest attractionRequest, @PathVariable Long id) {
        attractionService.putAttraction(attractionRequest, id);
        return ResponseEntity.ok().build();
    }
}
