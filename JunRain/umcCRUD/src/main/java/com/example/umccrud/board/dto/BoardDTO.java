package com.example.umccrud.board.dto;

import com.example.umccrud.board.domain.entity.BoardEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BoardDTO {
    @NotBlank(message = "제목이 비어있으면 안됩니다.")
    private String title;
    private String content;

    public BoardEntity toEntity() {
        return BoardEntity.builder().
                title(this.getTitle())
                .content(this.getContent())
                .build();
    }
}
