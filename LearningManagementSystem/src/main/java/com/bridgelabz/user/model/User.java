package com.bridgelabz.user.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="user")
public class User {

	@Id
	private Integer id;
	private String name;
	private String password;
	private String email;
	private LocalDate registerdate;
	
	public LocalDate getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(LocalDate registerdate) {
		this.registerdate = registerdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", registerdate="
				+ registerdate + "]";
	}
	
}
