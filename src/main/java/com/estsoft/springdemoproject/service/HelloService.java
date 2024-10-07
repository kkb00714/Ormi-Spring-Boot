package com.estsoft.springdemoproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class HelloService {

    public String printHello (String param) {
        return "Hello " + param;
    }
}
