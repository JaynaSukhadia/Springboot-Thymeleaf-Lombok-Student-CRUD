package com.aurosoft.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.student.entity.Course;
import com.aurosoft.student.entity.Student;
import com.aurosoft.student.service.CourseService;
import com.aurosoft.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	private	StudentService studentService;
	@Autowired
	private CourseService courseService;
	

		public StudentController(StudentService studentService, CourseService courseService) {
		super();
		this.studentService = studentService;
		this.courseService = courseService;
	}

	@GetMapping("/list")
	public String listAllStudent(Model m)
	{
		List<Student> list=studentService.listAllByStudents();
		m.addAttribute("list", list);
		return "Student/list";
	}
	
	@GetMapping("/new")
	public String showForm(Student student,Model m)
	{
		List<Course> list=courseService.listAllCourse();
		m.addAttribute("listcourse",list);
		return "Student/add";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute("student")Student student)
	{
		studentService.insertStudent(student);
		return "redirect:/student/list";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Student student = studentService.getStudentById(id);
		m.addAttribute("student",student);
		List<Course> list=courseService.listAllCourse();
		m.addAttribute("listcourse",list);
		return "/Student/edit";
	}
	
	@PostMapping(value="/update")
	public String update(@ModelAttribute("student") Student student)
	{
		studentService.updateStudent(student);
		return "redirect:/student/list";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable int id)
	{
		studentService.deleteStudent(id);
		return "redirect:/student/list";
	}
	
}
