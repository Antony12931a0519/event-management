package com.realtime.collegemanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.realtime.collegemanagement.entities.Student;

public interface StudentDAO extends CrudRepository<Student, Integer> {
	//boiler plate code
	
//seklect * from student where name = 'bsdmbf'
	public Student findStudentByName(String name);
	
	//seklect * from student where address = 'bsdmbf'
	public Student findStudentByAddress(String name);
	


}
