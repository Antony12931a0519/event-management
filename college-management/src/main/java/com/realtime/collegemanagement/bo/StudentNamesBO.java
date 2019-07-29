package com.realtime.collegemanagement.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtime.collegemanagement.dao.StudentNamesDAO;
import com.realtime.collegemanagement.entities.StudentNames;

@Service
public class StudentNamesBO {

	@Autowired
	StudentNamesDAO studentNamesDAO;

	public List<StudentNames> getStudentList() {
		// type casting

		return (List<StudentNames>) studentNamesDAO.findAll();

	}

	public int getCountOfStudent() {
		return (int) studentNamesDAO.count();
	}

	public StudentNames insertStudentDetails(StudentNames studentNames) {

		StudentNames student = studentNamesDAO.save(studentNames);
		return student;

	}

	public StudentNames updateStudentDetails(StudentNames studentNames)
			throws Exception {

		Optional<StudentNames> existingDetails = studentNamesDAO
				.findById(studentNames.getSid());
		StudentNames student = existingDetails.get();

		if (student != null) {
			
			student.setSname(studentNames.getSname());
			
			studentNamesDAO.save(student);

		} else {

			throw new Exception("Student details are not existing");
		}
		return student;

	}

}