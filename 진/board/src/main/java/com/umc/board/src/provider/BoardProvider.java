package com.umc.board.src.provider;

import com.umc.board.config.service.EntityLoader;
import com.umc.board.config.service.QueryService;
import com.umc.board.src.dao.BoardRepository;
import com.umc.board.src.dto.BoardResponse;
import com.umc.board.src.entity.Board;
import com.umc.board.src.entity.BoardType;
import com.umc.board.src.exception.SearchWordBlankException;
import com.umc.board.src.mapper.BoardMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@QueryService
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BoardProvider implements EntityLoader<Board, Long> {
    BoardRepository boardRepository;
    BoardMapper boardMapper;

    public Board loadEntity(Long id) {
        return boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public BoardResponse getBoard(Long id) {
        Board board = loadEntity(id);
        return boardMapper.toResponse(board);
    }

    public List<BoardResponse> getBoardListByType(BoardType type) {
        List<Board> boardList = boardRepository.findAllByType(type);
        return boardMapper.toResponseList(boardList);
    }

    public List<BoardResponse> getBoardListByWord(String q) {
        validateSearchWord(q);
        List<Board> boardList = boardRepository.findAllByTitleContainsIgnoreCase(q);
        return boardMapper.toResponseList(boardList);
    }

    private void validateSearchWord(String q) {
        if (!StringUtils.hasText(q)) throw new SearchWordBlankException();
    }
}
