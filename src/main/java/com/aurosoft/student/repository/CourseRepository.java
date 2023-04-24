package com.aurosoft.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.student.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
