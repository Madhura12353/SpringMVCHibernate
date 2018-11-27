package com.student.demo.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.demo.model.Student;

@Repository
public class StudentHibernateRepository {
	
@Autowired
DatabaseConnectivity databaseConnection ;

 public void insertindatabase(Student std) {
	Session s =  databaseConnection.getSession();
	 Transaction t = s.beginTransaction();
	s.save(std);
	t.commit();
 }
 
 public Student selectfromdatabase(int  id) {
		Session s =  databaseConnection.getSession();
		 Transaction t = s.beginTransaction();
		 Student std = (Student) s.get(Student.class, id);
		t.commit();
		return std;
	 }
	
}
