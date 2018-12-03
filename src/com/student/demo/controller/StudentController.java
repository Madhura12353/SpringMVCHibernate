package com.student.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.demo.model.bo.Login;
import com.student.demo.model.bo.StudentBO;
import com.student.demo.model.bo.User;
import com.student.demo.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	/**
	 * This method is being used by JSR -303 validations
	 * This method helps to first trim the strings before sending them for validation
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String userLogin(Model model) {
		model.addAttribute("mylogin", new Login());
		return "login";
	}
	
	/**
	 * 
	 * Note:
	 * Following method implements JSR-303 validation rules.
	 * These rules are implemented as annotation to 'Login' class
	 * In order to apply these rules following configuration is done:
	 * 1) Make sure 'xmlns:mvc' is used while creating core bean and 'xsi:schemaLocation' mentions corresponding schema location in 'spring-mvc-servlet.xml' file.
	 * 2) 'validation-api' jar file dependency is added in pom.xml file (version 2.0.1.Final)
	 * 3) The pom.xml file has 'hibernate-validator' dependency with version '5.2.4.Final' (previous version 4.3.1.Final did not work)
	 * 4) The method should have first annotation as @Valid followed by @ModelAttribute. 
	 * 5) The second parameter should be 'BindingResult' which stores the information about JSR 303 validations.
	 * 
	 * @param login
	 * @param bindingResult
	 * @return
	 */

	@RequestMapping(value = "/login-form", method = RequestMethod.POST)
	public String validateUser(@Valid @ModelAttribute("mylogin") Login login, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "login";
		else {
			User user = studentService.getUser(login.getUsername(), login.getPassword());

			if (user.getUsername().trim().equals("madhura")) {
				return "home";
			} else {
				return "login";
			}
		}

	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String registerStudent(Model model) {
		model.addAttribute("student", new StudentBO());
		return "new-student-form";
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String createStudentProcess(@Valid @ModelAttribute("student")StudentBO std, BindingResult result, Model model) {

		if(result.hasErrors()) {
			model.addAttribute("student", std);
			return "new-student-form";
		}
		else {
			int id = studentService.createStudent(std);
			std.setId(id);
			model.addAttribute("Studentinfo", std);
			return "save-student-success";	
		}
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getStudent(Model model) {
		model.addAttribute("student", new StudentBO());
		return "get-student-form";
	}

	@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
	public String getStudentprocess(Model model, String id) {
		StudentBO std = studentService.getStudent(Integer.parseInt(id));
		model.addAttribute("studentinfo", std);
		return "get-student-success";

	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String pageNotFound() {
		return "fileNotFound";
	}

	// This is utility method which will get called by forgot password button
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public String resetPassword() {
		return "forgot-password";
	}
}
