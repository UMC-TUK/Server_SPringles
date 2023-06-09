package com.umc.board.src.entity;

import com.umc.board.global.audit.AuditListener;
import com.umc.board.global.audit.Auditable;
import com.umc.board.global.audit.BaseTime;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member implements Auditable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String name;

    @Column(nullable = false, unique = true)
    private String githubId;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));

    private String refreshToken;

    @Setter
    @Embedded
    @Column(nullable = false)
    private BaseTime baseTime;

    @Builder
    public Member(String githubId, String refreshToken) {
        this.githubId = githubId;
        this.refreshToken = refreshToken;
    }

    public List<SimpleGrantedAuthority> getRole() {
        return role.stream().map(Role::name).map(SimpleGrantedAuthority::new).toList();
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
