package com.umc.market.domain.category.mapper;

import com.umc.market.domain.category.dto.request.CategoryRequestDto;
import com.umc.market.domain.category.dto.response.CategoryResponseDto;
import com.umc.market.domain.category.entity.Categorys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    public Categorys toEntity(CategoryRequestDto categoryRequestDto){
        return Categorys.builder()
                .name(categoryRequestDto.getName())
                .categoryUUID(UUID.randomUUID())
                .build();
    }


    public CategoryResponseDto fromEntity(Categorys categorys){
        return CategoryResponseDto.builder()

//                .id(categorys.getId())
                .categoryUUID(categorys.getCategoryUUID())
                .name(categorys.getName())
                .createdDate(categorys.getCreatedDate() != null ? categorys.getCreatedDate().toString() : null)
                .modifiedDate(categorys.getModifiedDate() != null ? categorys.getModifiedDate().toString() : null)
                .build();
    }

}
