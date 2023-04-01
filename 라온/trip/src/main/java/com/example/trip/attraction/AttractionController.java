package com.example.trip.attraction;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attractions")
public class AttractionController {
    private final AttractionService attractionService;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody AttractionRequest attractionRequest){
        return ResponseEntity.ok(attractionService.saveAttraction(attractionRequest));
    }
}
