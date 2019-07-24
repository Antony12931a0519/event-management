package com.realtime.collegemanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "STUDENT")
public class Student {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;
	@Column(name = "NAME")
	private String name;   
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "MOBILE")
	private String mobile;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
