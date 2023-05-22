package com.umc.week.category.mapper;

import com.umc.week.category.dto.CategoryRequestDto;
import com.umc.week.category.dto.CategoryResponseDto;
import com.umc.week.category.entity.Categorys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    public Categorys toEntity(CategoryRequestDto categoryRequestDto){
        return Categorys.builder()
                .name(categoryRequestDto.getName())
                .categoryUuid(UUID.randomUUID())
                .build();
    }


    public CategoryResponseDto fromEntity(Categorys categorys){
        return CategoryResponseDto.builder()

                .categoryUuid(categorys.getCategoryUuid())
                .name(categorys.getName())
                .build();
    }

}
