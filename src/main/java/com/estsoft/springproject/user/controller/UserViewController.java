package com.estsoft.springproject.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    // GET /login 요청이 들어왔을 때 /login 페이지로 연결
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // GET /signup 요청이 들어왔을 때 회원가입 페이지로 연결
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

}
