package com.estsoft.springdemoproject.controller;

import com.estsoft.springdemoproject.interf.InterDependencyService;
import com.estsoft.springdemoproject.ioc.Member;
import com.estsoft.springdemoproject.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // DI를 사용해서 spring에게 제어권 맡기기
    // 필드 선언
    private final HelloService service;   // Dependency Injection
    private final InterDependencyService dependencyService;

    // 생성자 주입 방식
    public HelloController(HelloService service, InterDependencyService dependencyService) {
        this.service = service;
        this.dependencyService = dependencyService;
    }

    @GetMapping("/hello")  // 패턴 입력
    public String hello(@RequestParam(value = "param", defaultValue = " Spring!!") String param) {
        Member member = new Member(1, "kkb", "address");
        dependencyService.printMethod();
        return service.printHello(param) + member.toString();
    }


}