package com.estsoft.example.springdemoproject.controller;

import com.estsoft.example.springdemoproject.entity.LectureCourse;
import com.estsoft.example.springdemoproject.repository.LectureCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class LectureCourseController {
    @Autowired
    private LectureCourseRepository lectureCourseRepository;

    @PostMapping("/lecture/course")
    public void savelecturecourse(
            @RequestParam String title,
            @RequestParam Long instructorId,
            @RequestParam Integer capacity,
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
            @RequestParam
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to,
            @RequestParam(required = false) String desc
    ) {
        LectureCourse entity = new LectureCourse();
        entity.setTitle(title);
        entity.setInstructorId(instructorId);
        entity.setCapacity(capacity);
        entity.setFrom(from);
        entity.setTo(to);
        entity.setDesc(desc);
        lectureCourseRepository.save(entity);
    }
}
