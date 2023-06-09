package com.umc.trip.attraction.service;

import com.umc.trip.attraction.dto.request.AttractionRequest;
import com.umc.trip.attraction.entity.Attraction;
import com.umc.trip.attraction.mapper.AttractionMapper;
import com.umc.trip.attraction.repository.AttractionRepository;
import com.umc.trip.global.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;
    private final AttractionMapper attractionMapper;

    public IdResponse<Long> saveAttraction(AttractionRequest request) {
        Attraction attraction = attractionRepository.save(attractionMapper.toEntity(request));
        return new IdResponse<>(attraction.getId());
    }

    @Transactional
    public void putAttraction(AttractionRequest request, Long id) {
        getEntity(id).update(request.getName(), request.getAddress(), request.getSeason());
    }

    public List<Attraction> getAttractions(List<String> attractionNames) {
        return attractionNames.stream()
                .map(attractionRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    private Attraction getEntity(Long id) {
        return attractionRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
