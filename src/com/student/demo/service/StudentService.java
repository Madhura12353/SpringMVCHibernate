package com.student.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.model.bo.StudentBO;
import com.student.demo.model.bo.User;
import com.student.demo.repository.StudentHibernateRepository;


@Service
public class StudentService {
	
	int id = 0;

	@Autowired
	StudentHibernateRepository studentRepo;
	
	
	
	public User getUser(String username, String password) {
		User user = new User(username, password);
		return user;
	}
	

	public int createStudent(StudentBO studentBO) {
		id++;
		studentBO.setId(id);

		studentRepo.insertindatabase(studentBO);
		return id;

	}

	public StudentBO getStudent(int id) {

		StudentBO studentBO = studentRepo.selectfromdatabase(id);
		return studentBO;

	}

	

}
