package com.example.umccrud.board.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class NoBoardException extends RuntimeException{
    public NoBoardException() {
        super();
    }

    public NoBoardException(String message) {
        super(message);
    }
}
