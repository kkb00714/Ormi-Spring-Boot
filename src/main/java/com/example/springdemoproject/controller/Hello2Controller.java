package com.example.springdemoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello2Controller {

    @GetMapping("Hi")
    public String printHello() {
        return "hi";
    }
}
