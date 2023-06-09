package com.umc.board.config.service;

public interface EntityLoader<T, ID> {
    T loadEntity(ID id);
}
