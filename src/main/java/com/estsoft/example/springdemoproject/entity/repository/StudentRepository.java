package com.estsoft.example.springdemoproject.entity.repository;

import com.estsoft.example.springdemoproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
