package com.ty.visitot.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Visitor {
	private int id;
	private String name;
	private String email;
	private String phone;
	private int age;
	private String gender;
	private LocalDate dob;
	private LocalDateTime visitorDateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDateTime getVisitorDateTime() {
		return visitorDateTime;
	}

	public void setVisitorDateTime(LocalDateTime visitorDateTime) {
		this.visitorDateTime = visitorDateTime;
	}

}
