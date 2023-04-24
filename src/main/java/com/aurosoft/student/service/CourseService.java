package com.aurosoft.student.service;

import java.util.List;

import com.aurosoft.student.entity.Course;

public interface CourseService {

	List<Course> listAllCourse();
	Course getCourseById(int id);
	Course insertCourse(Course course);
	Course updateCourse(Course course);
	int deleteCourse(int id);
	
	
}
