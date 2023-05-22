package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// DataNotFoundException 발생시 404 오류를 나타냄.
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
