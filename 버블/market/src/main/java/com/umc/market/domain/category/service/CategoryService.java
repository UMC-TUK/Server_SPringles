package com.umc.market.domain.category.service;

import com.umc.market.domain.category.dto.request.CategoryRequestDto;
import com.umc.market.domain.category.dto.request.CategoryUpdateDto;
import com.umc.market.domain.category.dto.response.CategoryResponseDto;
import com.umc.market.domain.category.entity.Categorys;
import com.umc.market.domain.category.exception.CategoryNotFoundException;
import com.umc.market.domain.category.mapper.CategoryMapper;
import com.umc.market.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;


    @Transactional
    public Categorys saveCategory(CategoryRequestDto categoryRequestDto) {
        return categoryRepository.save(categoryMapper.toEntity(categoryRequestDto));
    }


    @Transactional
    public List<CategoryResponseDto> getAllCategory() {
        List<Categorys> categoryies = categoryRepository.findAllByIsDeletedFalse();
        return categoryies.stream()
                .map(categoryMapper::fromEntity)
                .collect(Collectors.toList());
    }





    @Transactional
    public void updateCategory(UUID categoryUUID, CategoryUpdateDto updateDto){
        Categorys category = categoryRepository.findByCategoryUUID(categoryUUID);
        category.update(updateDto.getName());
        categoryRepository.save(category);
    }



    @Transactional
    public void deleteCategory(UUID categoryUUID) {
        Categorys category = categoryRepository.findByCategoryUUID(categoryUUID);
        if (category == null) {
            throw new CategoryNotFoundException("Category not found " + categoryUUID);
        }
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }



}
