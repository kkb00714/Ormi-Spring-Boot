package com.estsoft.example.springdemoproject.controller;

import com.estsoft.example.springdemoproject.entity.Student;
import com.estsoft.example.springdemoproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentJpaController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student/{id}")
    public String getStudentName(@PathVariable Long id) {
        return studentRepository.findById(id).get().getName();
    }

    @PostMapping("/student")
    public Long saveStudent(
            @RequestParam String name,
            @RequestParam Integer age,
            @RequestParam(required = false) String desc
    ) {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setDesc(desc);
        studentRepository.save(student);

        return student.getId();
    }
}
