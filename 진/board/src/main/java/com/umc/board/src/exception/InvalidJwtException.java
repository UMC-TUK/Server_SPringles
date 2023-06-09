package com.umc.board.src.exception;

public class InvalidJwtException extends IllegalStateException {
    private static final String MESSAGE = "Jwt 토큰 검증에서 오류가 발생했습니다.";

    public InvalidJwtException() {
        super(MESSAGE);
    }
}
