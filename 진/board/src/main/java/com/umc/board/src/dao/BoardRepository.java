package com.umc.board.src.dao;

import com.umc.board.src.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardQueryRepository {}
