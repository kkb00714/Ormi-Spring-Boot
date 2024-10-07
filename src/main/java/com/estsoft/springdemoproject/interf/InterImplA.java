package com.estsoft.springdemoproject.interf;

import org.springframework.stereotype.Service;

@Service
public class InterImplA implements Inter {

    @Override
    public void method() {
        System.out.println("hi this is A");
    }
}
