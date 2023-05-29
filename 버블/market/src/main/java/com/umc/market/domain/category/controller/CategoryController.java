package com.umc.market.domain.category.controller;


import com.umc.market.domain.category.dto.request.CategoryRequestDto;
import com.umc.market.domain.category.dto.request.CategoryUpdateDto;
import com.umc.market.domain.category.dto.response.CategoryResponseDto;
import com.umc.market.domain.category.entity.Categorys;
import com.umc.market.domain.category.exception.CategoryNotFoundException;
import com.umc.market.domain.category.mapper.CategoryMapper;
import com.umc.market.domain.category.repository.CategoryRepository;
import com.umc.market.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    // 카테고리 추가
    @PostMapping()
    public CategoryResponseDto saveCategory (@Validated @RequestBody CategoryRequestDto categoryRequestDto) {
        Categorys saveCategorys = categoryService.saveCategory(categoryRequestDto);
        return categoryMapper.fromEntity(saveCategorys);
    }

    // 카테고리 조회
    @GetMapping()
    public ResponseEntity<List<CategoryResponseDto>> getCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

//     카테고리 수정
    @PutMapping("/{categoryUUID}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable UUID categoryUUID, @Validated @RequestBody CategoryUpdateDto updateDto) {
        categoryService.updateCategory(categoryUUID, updateDto);
        Categorys updatedCategory = categoryRepository.findByCategoryUUID(categoryUUID);
        CategoryResponseDto responseDto = categoryMapper.fromEntity(updatedCategory);
        return ResponseEntity.ok(responseDto);
    }

    // 카테고리 삭제
    @DeleteMapping("/{categoryUUID}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID categoryUUID) {
        categoryService.deleteCategory(categoryUUID);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
