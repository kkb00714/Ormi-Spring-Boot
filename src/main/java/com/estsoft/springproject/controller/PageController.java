package com.estsoft.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class PageController {
    // Person
    @GetMapping("/thymeleaf/example")
    public String show(Model model) {
        Person person = new Person();
        person.setId(1L);
        person.setName("김자바");
        person.setAge(23);
        person.setHobbies(Arrays.asList("게임", "영화보기", "독서", "..."));

        model.addAttribute("person", person);
        model.addAttribute("today", LocalDateTime.now());
        // key - value 형태로 person에 접근할 수 있다.
        return "examplePage"; // html 페이지 리턴
    }
}
