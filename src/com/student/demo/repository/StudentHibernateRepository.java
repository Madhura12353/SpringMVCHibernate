package com.student.demo.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.demo.model.bo.StudentBO;
import com.student.demo.model.dao.StudentDAO;

@Repository
public class StudentHibernateRepository {

	@Autowired
	DatabaseConnectivity databaseConnection;

	public void insertindatabase(StudentBO bo) {
		StudentDAO dao = new StudentDAO();

		dao.setFirstname(bo.getFirstname());
		dao.setLastname(bo.getLastname());
		dao.setAddress(bo.getAddress());
		dao.setEmail(bo.getEmail());
		dao.setPhone(bo.getPhone());
		dao.setId(bo.getId());
		

		Session s = databaseConnection.getSession();
		Transaction t = s.beginTransaction();
		s.save(dao);
		t.commit();
	}

	public StudentBO selectfromdatabase(int id) {
		
		Session s = databaseConnection.getSession();
		Transaction t = s.beginTransaction();
		StudentDAO dao = (StudentDAO) s.get(StudentDAO.class, id);
		
		t.commit();
		
		StudentBO bo = new StudentBO();
		
		bo.setFirstname(dao.getFirstname());
		bo.setLastname(dao.getLastname());
		bo.setAddress(dao.getAddress());
		bo.setEmail(dao.getEmail());
		bo.setPhone(dao.getPhone());
		bo.setId(dao.getId());
		
		return bo;
	}

}
