package com.umc.week.atraction.service;

import com.umc.week.atraction.dto.AtractionRequest;
import com.umc.week.atraction.entity.Atraction;
import com.umc.week.atraction.mapper.AtractionMapper;
import com.umc.week.atraction.repository.AtractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AtractionService {

    public final AtractionRepository atractionRepository;

    public final AtractionMapper atractionMapper;

    @Transactional
    public Atraction addAtraction(AtractionRequest atractionRequest){
        return atractionRepository.save(atractionMapper.toEntity(atractionRequest));
    }

}
