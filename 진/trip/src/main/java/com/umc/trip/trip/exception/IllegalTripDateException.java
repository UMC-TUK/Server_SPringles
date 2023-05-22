package com.umc.trip.trip.exception;

public class IllegalTripDateException extends IllegalArgumentException {
    private static final String MESSAGE = "여행 날짜는 오늘보다 빠를 수 없습니다.";

    public IllegalTripDateException() {
        super(MESSAGE);
    }
}
