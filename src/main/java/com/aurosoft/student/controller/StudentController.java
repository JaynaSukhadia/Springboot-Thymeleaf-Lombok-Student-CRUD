package com.aurosoft.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aurosoft.student.entity.Student;
import com.aurosoft.student.service.StudentService;

@Controller
public class StudentController {

	
	@Autowired
	StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	@GetMapping("/list")
	public String listAllStudent(Model m)
	{
		List<Student> list=studentService.listAllByStudents();
		m.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/new")
	public String showForm(Student student)
	{
		return "/add";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute("student")Student student)
	{
		studentService.insertStudent(student);
		return "redirect:/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Student student = studentService.getStudentById(id);
		m.addAttribute("student",student);
		return "/edit";
	}
	
	@PostMapping(value="/update")
	public String update(@ModelAttribute("student") Student student)
	{
		studentService.updateStudent(student);
		return "redirect:/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable int id)
	{
		studentService.deleteStudent(id);
		return "redirect:/list";
	}
	
}
