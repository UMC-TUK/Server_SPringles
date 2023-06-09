package com.umc.board.src.provider;

import com.umc.board.config.service.QueryService;
import com.umc.board.src.dao.BoardRepository;
import com.umc.board.src.dto.BoardResponse;
import com.umc.board.src.entity.Board;
import com.umc.board.src.entity.BoardType;
import com.umc.board.src.exception.SearchWordBlankException;
import com.umc.board.src.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@QueryService
@RequiredArgsConstructor
public class BoardProvider {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public Board getEntity(Long id) {
        return boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public BoardResponse getBoard(Long id) {
        Board board = getEntity(id);
        return boardMapper.toResponse(board);
    }

    public List<BoardResponse> getBoardListByType(BoardType type) {
        List<Board> boardList = boardRepository.findByType(type);
        return boardMapper.toResponseList(boardList);
    }

    public List<BoardResponse> getBoardListByWord(String q) {
        validateSearchWord(q);
        List<Board> boardList = boardRepository.findByTitleContainsIgnoreCase(q);
        return boardMapper.toResponseList(boardList);
    }

    private void validateSearchWord(String q) {
        if (!StringUtils.hasText(q)) {
            throw new SearchWordBlankException();
        }
    }
}
