package com.example.umccrud.board.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
@Getter
public class BoardEntity {
    @Id@GeneratedValue
    private Long id;

    @NonNull
    private String title;

    private String content;

    @Builder
    public BoardEntity(@NonNull String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateBord(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
