package com.example.usedcar.service;

import com.example.usedcar.dto.requestdto.UsedCarRequestDto;
import com.example.usedcar.dto.responsedto.UsedCarResponseDto;
import com.example.usedcar.entity.UsedCar;
import com.example.usedcar.mapper.UsedCarMapper;
import com.example.usedcar.repository.UsedCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UsedCarService {
    private UsedCarRepository usedCarRepository;
    private UsedCarMapper usedCarMapperImpl;

    @Autowired
    public UsedCarService(UsedCarRepository usedCarRepository, UsedCarMapper usedCarMapperImpl){
        this.usedCarRepository = usedCarRepository;
        this.usedCarMapperImpl = usedCarMapperImpl;
    }
    public UsedCarResponseDto getUsedCar(Long id){
        return usedCarMapperImpl.toResponseDto(getEntity(id));
    }

    public Long saveUsedCar(UsedCarRequestDto usedCar){
        UsedCar entity = usedCarRepository.save(usedCarMapperImpl.toEntity(usedCar));
        return entity.getId();
    }

    public Long deleteUsedCar(Long id){
        usedCarRepository.deleteById(id);
        return id;
    }

    private UsedCar getEntity(Long id) {
        return usedCarRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public String updateNameUsedCar(Long id, UsedCarRequestDto usedCar) {
        usedCarRepository.updateName(id, usedCar.getName());
        return usedCar.getName();
    }

    public Long updateCar(Long id, UsedCarRequestDto usedCar) {
        UsedCar entity = usedCarRepository.save(usedCarMapperImpl.toEntity(usedCar));
        return entity.getId();
    }

    public Long updateUsedCar(Long id, UsedCarRequestDto usedCar) {
        usedCarRepository.updateAll(id,usedCar.getName(),usedCar.getColor(),usedCar.getMileage(),usedCar.getPrice(),usedCar.getModel_year());
        return id;
    }
}
