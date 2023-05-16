package com.umc.board.src.exception;

public class SearchWordBlankException extends IllegalArgumentException {
    private static final String MESSAGE = "검색어가 비어있습니다.";

    public SearchWordBlankException() {
        super(MESSAGE);
    }
}
