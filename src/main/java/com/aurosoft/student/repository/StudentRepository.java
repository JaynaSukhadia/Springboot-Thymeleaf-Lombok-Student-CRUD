package com.aurosoft.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
