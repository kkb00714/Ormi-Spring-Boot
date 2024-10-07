package com.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

// POJO (Pure Object JAVA Object)
@AllArgsConstructor
// @NoARgsConstructor (아규먼트가 없는 생성자 생성),
// @RequiredArgsConstructor (final로 선언했을 때, 그 필드만 생성자에 넣어주는 어노테이션)
@Getter
@Setter
public class People {
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;


}

