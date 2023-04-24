package com.aurosoft.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.student.entity.Course;
import com.aurosoft.student.repository.CourseRepository;
import com.aurosoft.student.service.CourseService;


@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	 CourseRepository repo;
	@Override
	public List<Course> listAllCourse() {
		
		return repo.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Course insertCourse(Course course) {
		
		return repo.save(course);
	}

	@Override
	public Course updateCourse(Course course) {
		
		return repo.save(course);
	}

	@Override
	public int deleteCourse(int id) {
		repo.deleteById(id);
		return id;
	}

}
