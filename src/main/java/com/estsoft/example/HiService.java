package com.estsoft.example;

import org.springframework.stereotype.Service;

@Service
public class HiService {
    public String printService (String param) {
        return "Hello " + param;
    }
}
