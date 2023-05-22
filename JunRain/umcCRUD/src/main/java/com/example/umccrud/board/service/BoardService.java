package com.example.umccrud.board.service;

import com.example.umccrud.board.dto.BoardDTO;
import com.example.umccrud.board.domain.entity.BoardEntity;
import com.example.umccrud.board.domain.repository.BoardRepository;
import com.example.umccrud.board.config.NoBoardException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    final private BoardRepository boardRepository;

    public void createBord(BoardDTO boardDTO) {
        boardRepository.save(boardDTO.toEntity());
    }

    public BoardEntity searchBord(String title) {
        return boardRepository.findByTitle(title).orElseThrow(NoBoardException::new);
    }

    public void updateBoard(String title, BoardDTO boardDTO) {
        BoardEntity boardEntity = boardRepository.findByTitle(title).orElseThrow(NoBoardException::new);
        boardEntity.updateBord(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(boardEntity);
    }

    public void deleteBoard(String title) {
        BoardEntity boardEntity = boardRepository.findByTitle(title).orElseThrow(NoBoardException::new);
        boardRepository.delete(boardEntity);
    }

    public boolean isDuplicated(String title) {
        return boardRepository.existsByTitle(title);
    }
}
