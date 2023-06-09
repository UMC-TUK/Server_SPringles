package com.umc.board.src.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * OAuth2 로그인 확인용
 */

@Controller
public class LoginController {

    @GetMapping
    public String login() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
