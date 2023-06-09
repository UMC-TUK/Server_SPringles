package com.umc.board.config.security.oauth;

import com.umc.board.config.security.oauth.user.UserDetailsMapper;
import com.umc.board.src.dao.MemberRepository;
import com.umc.board.src.entity.Member;
import com.umc.board.src.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;
    private final UserDetailsMapper userDetailsMapper;
    private final MemberMapper memberMapper;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String githubId = (String) attributes.get("login");

        Member user = memberRepository.findByGithubId(githubId)
                .orElseGet(() -> memberRepository.save(memberMapper.toEntity(githubId)));

        return userDetailsMapper.mapToLoginUser(user);
    }
}
