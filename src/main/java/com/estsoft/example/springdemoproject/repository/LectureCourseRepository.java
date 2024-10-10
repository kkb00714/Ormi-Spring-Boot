package com.estsoft.example.springdemoproject.repository;

import com.estsoft.example.springdemoproject.entity.LectureCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureCourseRepository extends JpaRepository<LectureCourse, Long> {

}
