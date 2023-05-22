package com.umc.week.category.controller;

import com.umc.week.category.dto.CategoryRequestDto;
import com.umc.week.category.dto.CategoryResponseDto;
import com.umc.week.category.entity.Categorys;
import com.umc.week.category.mapper.CategoryMapper;
import com.umc.week.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    @PostMapping()
    public CategoryResponseDto saveCategory (@RequestBody CategoryRequestDto categoryRequestDto) {
        Categorys saveCategorys = categoryService.saveCategory(categoryRequestDto);
        return categoryMapper.fromEntity(saveCategorys);
    }


    @GetMapping()
    public ResponseEntity<List<CategoryResponseDto>> getCategory() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

}
