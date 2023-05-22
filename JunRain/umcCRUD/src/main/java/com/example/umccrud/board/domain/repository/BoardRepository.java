package com.example.umccrud.board.domain.repository;

import com.example.umccrud.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    public Optional<BoardEntity> findByTitle(String title);
    public boolean existsByTitle(String title);

}
