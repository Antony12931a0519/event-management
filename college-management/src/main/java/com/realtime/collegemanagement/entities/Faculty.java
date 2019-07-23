package com.realtime.collegemanagement.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "FACULTY")
public class Faculty {
	@Id
	@Column(name = "FACULTY_ID")
	private int facultyId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SUBJECT")
	private String subject;

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
