package com.umc.board.config.security.oauth.user;

import com.umc.board.src.entity.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDetailsMapper {
    public UserDetailsImpl mapToLoginUser(Member user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        return new UserDetailsImpl(user, user.getRole(), attributes);
    }
}
