package com.aurosoft.student.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aurosoft.student.entity.Course;
import com.aurosoft.student.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping("/list")
	public String listAll(Model m)
	{
		List<Course> list = courseService.listAllCourse();
		m.addAttribute("list", list);
		return "/Course/list";
	}

	@GetMapping("/new")
	public String ShowForm(Course course)
	{
		return "Course/add";
	}
	
	@PostMapping("/insert")
	public String insertCourse(@ModelAttribute("course") Course course)
	{
		courseService.insertCourse(course); 
		return "redirect:/course/list";
	}
	@GetMapping(value="/edit/{id}")
	public String editCourse(@PathVariable int id,Model m)
	{
		Course course=courseService.getCourseById(id);
		m.addAttribute("course",course);
		return "/Course/edit";
	}
	
	@PostMapping(value="/update")
	public String updateCourse(@ModelAttribute("course")Course course)
	{
		courseService.updateCourse(course);
		return "redirect:/course/list";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable int id)
	{
		courseService.deleteCourse(id);
		return "redirect:/course/list";
	}
}
