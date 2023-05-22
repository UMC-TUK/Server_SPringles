package com.umc.board.src.mapper;

import com.umc.board.src.dto.BoardRequest;
import com.umc.board.src.dto.BoardResponse;
import com.umc.board.src.entity.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BoardMapper {
    public Board toEntity(BoardRequest dto) {
        return Board.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .type(dto.getType())
                .build();
    }

    public BoardResponse toResponse(Board entity) {
        return BoardResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
    }

    public List<BoardResponse> toResponseList(List<Board> boardList) {
        return boardList.stream().map(this::toResponse).collect(Collectors.toList());
    }
}
