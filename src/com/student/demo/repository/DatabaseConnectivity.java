package com.student.demo.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Component;


import com.student.demo.model.Student;



@Component
public class DatabaseConnectivity {
	
	private Session session;
	public DatabaseConnectivity() {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf = con.buildSessionFactory(reg);
		
		 this.session = sf.openSession();
		
		
		
	}
	
	public Session getSession() {
		   
		return this.session;
	}
	

}
