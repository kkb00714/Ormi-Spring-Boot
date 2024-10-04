package com.example.springdemoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")  // 패턴 입력
    public String hello(@RequestParam(value = "param", defaultValue = " Spring!!") String param) {
        return "hello" + param;
    }
}
