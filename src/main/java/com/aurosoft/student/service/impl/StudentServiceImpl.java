package com.aurosoft.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurosoft.student.entity.Student;
import com.aurosoft.student.repository.StudentRepository;
import com.aurosoft.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository repo;
	
	@Override
	public List<Student> listAllByStudents() {
		
		return repo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		
		return repo.findById(id).orElseThrow();
	}

	@Override
	public Student insertStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public int deleteStudent(int id) {
		repo.deleteById(id);
		return id;
	}

}
