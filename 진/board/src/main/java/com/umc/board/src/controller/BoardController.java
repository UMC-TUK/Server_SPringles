package com.umc.board.src.controller;

import com.umc.board.src.entity.BoardType;
import com.umc.board.src.provider.BoardProvider;
import com.umc.board.src.service.BoardService;
import com.umc.board.src.dto.BoardRequest;
import com.umc.board.src.dto.BoardResponse;
import com.umc.board.src.dto.IdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService boardService;
    private final BoardProvider boardProvider;

    @PostMapping
    public ResponseEntity<IdResponse> postBoard(@RequestBody @Valid BoardRequest boardRequest) {
        return ResponseEntity.ok(boardService.postBoard(boardRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardProvider.getBoard(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putBoard(@RequestBody @Valid BoardRequest boardRequest, @PathVariable Long id) {
        boardService.putBoard(boardRequest, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getBoardList(@RequestParam BoardType type) {
        return ResponseEntity.ok(boardProvider.getBoardListByType(type));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BoardResponse>> getBoardListByWord(@RequestParam String q) {
        return ResponseEntity.ok(boardProvider.getBoardListByWord(q));
    }
}
