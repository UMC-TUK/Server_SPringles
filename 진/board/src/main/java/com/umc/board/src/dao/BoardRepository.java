package com.umc.board.src.dao;

import com.umc.board.src.entity.Board;
import com.umc.board.src.entity.BoardType;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<Board> findByType(BoardType type);
    List<Board> findByTitleContainsIgnoreCase(String title);
    Board save(Board board);
    void deleteById(Long id);
    Optional<Board> findById(Long id);
}
