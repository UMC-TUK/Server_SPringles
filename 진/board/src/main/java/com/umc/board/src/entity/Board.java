package com.umc.board.src.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private BoardType type;

    @Builder
    public Board(String title, String content, BoardType type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public void update(String title, String content, BoardType type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }
}
