package com.student.demo.validator;

import com.student.demo.model.bo.Login;

public class LoginValidator {

	public static String validate(Login login) {
		if(login.getUsername()==null || login.getUsername().isEmpty())
			return "username is empty";
		else if(login.getUsername().length()<2 || login.getUsername().length()>10)
			return "invalid username length. Should be between 2 and 10 ";
		
		if(login.getPassword()==null || login.getPassword().isEmpty())
			return "password is empty";
		else if(login.getPassword().length()<2 || login.getPassword().length()>10)
			return "invalid password length. Should be between 2 and 10 ";
		
		return null;
	}
}
