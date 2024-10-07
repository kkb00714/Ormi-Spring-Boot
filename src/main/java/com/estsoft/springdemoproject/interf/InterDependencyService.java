package com.estsoft.springdemoproject.interf;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InterDependencyService {
    private final Inter inter;

    // interface 타입으로 의존성 주입(DI) 할때 구현체 지정 방법 2가지
    // 1. @Qualifier("빈 이름(구현체) 지정")   ex. @Qualifier("interImplA")

//    public InterDependencyService(@Qualifier("interImplB") Inter inter) {
//        this.inter = inter;
//    }

    // 2. Primary
    public InterDependencyService(Inter inter) {
        this.inter = inter;
    }

    public void printMethod() {
        inter.method();
    }

}