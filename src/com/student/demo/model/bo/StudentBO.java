package com.student.demo.model.bo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class StudentBO {
	
	private String username;
	
	private String password;
	
	@NotNull
	@Size(min=2,max=50,message="Invalid First Name")
	private String firstname;
	
	@NotNull
	@Size(min=2,max=50,message="Invalid Last Name")
	private String lastname;
	
	@NotNull
	@Size(min=2,max=50,message="Invalid Email address")
	private String email;
	
	@NotNull
	@Size(min=2,max=50,message="Invalid Address")
	private String address;
	
	@NotNull
	@Size(min=2,max=50,message="Invalid Phone Number")
	private String phone;
	
	public
	int id;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", id=" + id + "]";
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
