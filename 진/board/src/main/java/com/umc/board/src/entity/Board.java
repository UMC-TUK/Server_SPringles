package com.umc.board.src.entity;

import com.umc.board.global.audit.AuditListener;
import com.umc.board.global.audit.Auditable;
import com.umc.board.global.audit.BaseTime;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board implements Auditable {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private BoardType type;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

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
