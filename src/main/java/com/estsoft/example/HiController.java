package com.estsoft.example;

import com.estsoft.springdemoproject.ioc.Member;
import com.estsoft.springdemoproject.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    // DI를 사용해서 spring에게 제어권 맡기기
    // 필드 선언
    private final HelloService service;   // Dependency Injection

    // 생성자 주입 방식
    public HiController(HelloService service) {
        this.service = service;
    }

    @GetMapping("hicontroller")  // 패턴 입력
    public String hello(@RequestParam(value = "param", defaultValue = " Spring!!") String param) {
        Member member = new Member(1, "kkb", "address");
        return service.printHello(param) + member;
    }
}