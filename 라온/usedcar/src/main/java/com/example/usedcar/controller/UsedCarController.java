package com.example.usedcar.controller;

import com.example.usedcar.dto.requestdto.UsedCarRequestDto;
import com.example.usedcar.dto.responsedto.UsedCarResponseDto;
import com.example.usedcar.service.UsedCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/usedcars")
public class UsedCarController {
    private UsedCarService usedCarService;

    @Autowired
    public UsedCarController(UsedCarService usedCarService){
        this.usedCarService = usedCarService;
    }

    @PatchMapping ("/{id}")
    public ResponseEntity<String> updateUsedCarName(@PathVariable Long id, @RequestBody @Valid UsedCarRequestDto usedCar) {
        return ResponseEntity.ok(usedCarService.updateNameUsedCar(id, usedCar));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateUsedCar(@PathVariable Long id, @RequestBody @Valid UsedCarRequestDto usedCar){
        return ResponseEntity.ok(usedCarService.updateUsedCar(id,usedCar));
    }

    @PostMapping
    public ResponseEntity<Long> saveArticle(@RequestBody @Valid UsedCarRequestDto usedCar) {
        return ResponseEntity.ok(usedCarService.saveUsedCar(usedCar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsedCarResponseDto> getUsedCar(@PathVariable Long id) {
        return ResponseEntity.ok(usedCarService.getUsedCar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteUsedCar(@PathVariable Long id){
        return ResponseEntity.ok(usedCarService.deleteUsedCar(id));
    }

}
