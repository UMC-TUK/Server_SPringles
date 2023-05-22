package com.umc.week.atraction.controller;

import com.umc.week.atraction.dto.AtractionRequest;
import com.umc.week.atraction.dto.AtractionResponse;
import com.umc.week.atraction.entity.Atraction;
import com.umc.week.atraction.mapper.AtractionMapper;
import com.umc.week.atraction.service.AtractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/atractions")
public class AtractionController {

    private final AtractionService atractionService;

    private final AtractionMapper atractionMapper;

    @PostMapping
    public AtractionResponse addAtraction(@Validated @RequestBody AtractionRequest atractionRequest) {
        Atraction atraction = atractionService.addAtraction(atractionRequest);
        return atractionMapper.fromEntity(atraction);
    }
}
