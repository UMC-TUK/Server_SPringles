package com.umc.board.src.service;

import com.umc.board.global.service.CommandService;
import com.umc.board.src.dao.BoardRepository;
import com.umc.board.src.mapper.BoardMapper;
import com.umc.board.src.dto.BoardRequest;
import com.umc.board.src.dto.IdResponse;
import com.umc.board.src.entity.Board;
import com.umc.board.src.provider.BoardProvider;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@CommandService
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BoardService {
    BoardRepository boardRepository;
    BoardProvider boardProvider;
    BoardMapper boardMapper;

    public IdResponse postBoard(BoardRequest boardRequest) {
        Board board = boardRepository.save(boardMapper.toEntity(boardRequest));
        return new IdResponse(board.getId());
    }

    public void putBoard(BoardRequest boardRequest, Long id) {
        boardProvider.loadEntity(id).update(boardRequest.getTitle(), boardRequest.getContent(), boardRequest.getType());
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
