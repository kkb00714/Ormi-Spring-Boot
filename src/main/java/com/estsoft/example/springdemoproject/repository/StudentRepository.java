package com.estsoft.example.springdemoproject.repository;

import com.estsoft.example.springdemoproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
