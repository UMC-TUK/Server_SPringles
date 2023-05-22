package com.example.umccrud.board.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NoBoardException.class)
    public ResponseEntity<HttpStatus> memberNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
