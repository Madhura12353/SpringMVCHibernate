package com.student.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.student.demo.model.Login;
import com.student.demo.model.Student;
import com.student.demo.model.User;
import com.student.demo.service.StudentService;



@Controller
public class StudentHController {
	
	@Controller
	public class StudentController {
		@Autowired
		StudentService studentService;

		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public ModelAndView userLogin() {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("mylogin", new Login());
			return mav;

		}

		@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
		public ModelAndView validateUser(Login login) {
			ModelAndView mav;
			User user = studentService.getUser(login.getUsername(), login.getPassword());
			if (user.getUsername().trim().equals("madhura")) {
				mav = new ModelAndView("home");
			} else {
				mav = new ModelAndView("login");
				mav.addObject("mylogin", new Login());
			}

			return mav;

		}

		
		@RequestMapping(value = "/createStudent", method = RequestMethod.GET)
		public ModelAndView registerStudent() {
			ModelAndView mav = new ModelAndView("createStudent");
			mav.addObject("student", new Student());
			return mav;
		}
		
		@RequestMapping(value = "/createStudentProcess", method = RequestMethod.POST)
		public ModelAndView createStudentProcess(Student std) {
			ModelAndView mav;
		     int id = studentService.createStudent(std);
		     std.id = id;
			mav = new ModelAndView("registationSuccess");
			
			//mav.addObject("Studentinfo",std.firstname);
			mav.addObject("Studentinfo",std);
			return mav;
			}
		
		@RequestMapping(value = "/getStudent", method = RequestMethod.GET)
		public ModelAndView getStudent() {
			ModelAndView mav = new ModelAndView("getStudent");
			mav.addObject("student", new Student());
			return mav;
		}
		
		@RequestMapping(value = "/getStudentProcess", method = RequestMethod.GET)
		public ModelAndView getStudentprocess(String id) {
			System.out.println(id);
			ModelAndView mav = new ModelAndView("getStudentProcess");
			Student std= studentService.getStudent(Integer.parseInt(id));
	    	mav.addObject("studentinfo", std);
			return mav;
			
		}
		
		
}
}
