package com.umc.board.src.service;

import com.umc.board.config.annotation.CommandService;
import com.umc.board.src.dao.BoardQueryRepository;
import com.umc.board.src.mapper.BoardMapper;
import com.umc.board.src.dto.BoardRequest;
import com.umc.board.src.dto.IdResponse;
import com.umc.board.src.entity.Board;
import com.umc.board.src.provider.BoardProvider;
import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class BoardService {
    private final BoardQueryRepository boardQueryRepository;
    private final BoardProvider boardProvider;
    private final BoardMapper boardMapper;

    public IdResponse postBoard(BoardRequest boardRequest) {
        Board board = boardQueryRepository.save(boardMapper.toEntity(boardRequest));
        return new IdResponse(board.getId());
    }

    public void putBoard(BoardRequest boardRequest, Long id) {
        boardProvider.getEntity(id).update(boardRequest.getTitle(), boardRequest.getContent(), boardRequest.getType());
    }

    public void deleteBoard(Long id) {
        boardQueryRepository.deleteById(id);
    }
}
