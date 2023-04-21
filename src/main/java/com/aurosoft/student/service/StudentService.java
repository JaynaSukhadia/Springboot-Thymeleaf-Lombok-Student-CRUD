package com.aurosoft.student.service;

import java.util.List;

import com.aurosoft.student.entity.Student;

public interface StudentService {

	List<Student> listAllByStudents();
	Student getStudentById(int id);
	Student insertStudent(Student student);
	Student updateStudent(Student student);
	int deleteStudent(int id);
}
