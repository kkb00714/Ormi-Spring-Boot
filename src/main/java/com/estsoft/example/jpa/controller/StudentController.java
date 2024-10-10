package com.estsoft.example.jpa.controller;

public class StudentController {
    
    // DI의 여러 방법
    // 1. setter method를 통해서 DI 처리
    // 2. 생성자를 통해서 DI 처리
    // 3. @Autowired를 이용해서 처리
    // -> 각각의 장단점이 있고, 순환 참조(circular reference) 라는 문제가 있을 수 있음
    
    
    /* 순환참조 예시
    * StudentService 에서 LectureService를 참조하고
    * LectureService에서 StudentService를 참조할 경우
    * 
    * */
    // => 이 순환 참조를 방지 및 사전인지 하기 위해서 생성자 기반의 DI 처리를 사용할 수 있음.
    
}
