package com.umc.week.category.service;


import com.umc.week.category.dto.CategoryRequestDto;
import com.umc.week.category.dto.CategoryResponseDto;
import com.umc.week.category.entity.Categorys;
import com.umc.week.category.mapper.CategoryMapper;
import com.umc.week.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public Categorys saveCategory(CategoryRequestDto categoryRequestDto) {
        return categoryRepository.save(categoryMapper.toEntity(categoryRequestDto));
    }


    @Transactional
    public List<CategoryResponseDto> getAllCategory() {
        List<Categorys> categoryies = categoryRepository.findAll();
        return categoryies.stream()
                .map(categoryMapper::fromEntity)
                .collect(Collectors.toList());
    }


}
