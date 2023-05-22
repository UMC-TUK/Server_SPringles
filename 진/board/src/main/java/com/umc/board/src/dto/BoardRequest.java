package com.umc.board.src.dto;

import com.umc.board.src.entity.BoardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @NotNull
    private BoardType type;
}
