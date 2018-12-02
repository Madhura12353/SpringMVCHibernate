package com.student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.demo.model.Login;
import com.student.demo.model.Student;
import com.student.demo.model.User;
import com.student.demo.service.StudentService;

@Controller
public class StudentHController {
	
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin(Model model) {
		model.addAttribute("mylogin", new Login());
		return "login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String validateUser(Model model, Login login) {

		String view = "";
		User user = studentService.getUser(login.getUsername(), login.getPassword());

		if (user.getUsername().trim().equals("madhura")) {
			view = "home";
		} else {
			model.addAttribute("mylogin", new Login());
			view = "login";
		}
		return view;

	}

	@RequestMapping(value = "/createStudent", method = RequestMethod.GET)
	public String registerStudent(Model model) {
		model.addAttribute("student", new Student());
		return "createStudent";
	}

	@RequestMapping(value = "/createStudentProcess", method = RequestMethod.POST)
	public String createStudentProcess(Model model, Student std) {

		int id = studentService.createStudent(std);
		std.setId(id);
		model.addAttribute("Studentinfo", std);
		return "registationSuccess";
	}

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public String getStudent(Model model) {
		model.addAttribute("student", new Student());
		return "getStudent";
	}

	@RequestMapping(value = "/getStudentProcess", method = RequestMethod.GET)
	public String getStudentprocess(Model model, String id) {
		Student std = studentService.getStudent(Integer.parseInt(id));
		model.addAttribute("studentinfo", std);
		return "getStudentProcess";

	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

}
