package com.estsoft.springproject.user.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
    
    // GET /logout 요청이 들어오면 login 화면으로 리다이렉션
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

}
