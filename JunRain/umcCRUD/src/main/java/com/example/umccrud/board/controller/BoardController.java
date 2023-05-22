package com.example.umccrud.board.controller;

import com.example.umccrud.board.dto.BoardDTO;
import com.example.umccrud.board.domain.entity.BoardEntity;
import com.example.umccrud.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    final BoardService boardService;

    @PostMapping
    ResponseEntity<HttpStatus> saveBoard(@RequestBody @Valid BoardDTO boardDTO) {
        boolean isDuplicated = boardService.isDuplicated(boardDTO.getTitle());

        if(isDuplicated) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        boardService.createBord(boardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    ResponseEntity<BoardDTO> searchBoardByTitle(@RequestParam String title) {
        BoardEntity boardEntity = boardService.searchBord(title);
        BoardDTO boardDTO = BoardDTO.builder().title(boardEntity.getTitle()).content(boardEntity.getContent()).build();
        return ResponseEntity.status(HttpStatus.OK).body(boardDTO);
    }


    @PutMapping("/{title}")
    ResponseEntity<HttpStatus> modifyBoard(@PathVariable String title, @RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(title, boardDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/{title}")
    ResponseEntity<HttpStatus> modifyBoardByPatch(@PathVariable String title, @RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(title, boardDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{title}")
    ResponseEntity<HttpStatus> deleteBoard(@PathVariable String title) {
        boardService.deleteBoard(title);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
