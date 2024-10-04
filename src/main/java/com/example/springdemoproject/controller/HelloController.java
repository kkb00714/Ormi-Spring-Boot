package com.example.springdemoproject.controller;

import com.example.springdemoproject.ioc.Member;
import com.example.springdemoproject.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // DI를 사용해서 spring에게 제어권 맡기기
    // 필드 선언
    private final HelloService service;   // Dependency Injection

    // 생성자 주입 방식
    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")  // 패턴 입력
    public String hello(@RequestParam(value = "param", defaultValue = " Spring!!") String param) {
        Member member = new Member(1, "kkb", "address");
        return service.printHello(param) + member;
    }
}
