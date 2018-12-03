package com.student.demo.model.bo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Login {
	@NotNull
	@Size(min=2,max=50,message="Invalid length for User Name")
	@Pattern(regexp="[A-Za-z(\\s)]+", message="Invalid User Name")
	String username;

	@NotNull
	@Size(min=5,max=50,message="Invalid length for Password")
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
