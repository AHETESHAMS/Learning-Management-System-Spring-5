package com.bridgelabz.user.dto;

public class LoginDto {
	
	private String email;
	private String password;
	public LoginDto() {
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [emailId=" + email + ", password=" + password + "]";
	}

}
