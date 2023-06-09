package com.umc.board.global.service;

public interface EntityLoader<T, ID> {
    T loadEntity(ID id);
}
