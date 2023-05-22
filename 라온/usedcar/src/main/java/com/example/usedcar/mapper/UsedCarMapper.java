package com.example.usedcar.mapper;

import com.example.usedcar.dto.requestdto.UsedCarRequestDto;
import com.example.usedcar.dto.responsedto.UsedCarResponseDto;
import com.example.usedcar.entity.UsedCar;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "Spring")
public interface UsedCarMapper {
    UsedCarMapper INSTANCE = Mappers.getMapper(UsedCarMapper.class);

    UsedCar toEntity(UsedCarRequestDto dto);
    UsedCarResponseDto toResponseDto (UsedCar entity);
}
