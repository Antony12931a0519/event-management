package com.realtime.collegemanagement.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtime.collegemanagement.dao.StudentDAO;
import com.realtime.collegemanagement.entities.Student;
import com.realtime.collegemanagement.models.StudentModel;

//@Service @Controller @Component
@Service
public class StudentBO {
	// bean creation
	@Autowired
	private StudentDAO studentDAO;

	public List<StudentModel> getStudentList() {

		List<StudentModel> studentlist = new ArrayList<StudentModel>();
		// size 2 type casting
		List<Student> students = (List<Student>) studentDAO.findAll();

		System.out.println(students.size());

		for (Student ref : students) {

			StudentModel student = new StudentModel();
			student.setStudentId(ref.getStudentId());
			student.setName(ref.getName());
			student.setAddress(ref.getAddress());
			student.setMobile(ref.getMobile());

			studentlist.add(student);

		}

		return studentlist;

	}

	public Student creatStudent(StudentModel student) {

		Student studentData = new Student();
		studentData.setName(student.getName());
		studentData.setAddress(student.getAddress());
		studentData.setMobile(student.getMobile());

		studentData = studentDAO.save(studentData);
		return studentData;

	}

	public List<String> getStudentsByUniqueName() {

		Set<String> names = new HashSet<String>();
		// size 5
		List<Student> students = (List<Student>) studentDAO.findAll();

		for (Student ref : students) {

			names.add(ref.getName());

		}

		return new ArrayList<String>(names);

	}

	public Student updateStudent(StudentModel studentDetails) throws Exception {

		Optional<Student> existingStudent = studentDAO.findById(studentDetails
				.getStudentId());

		if (existingStudent != null) {

			Student details = existingStudent.get();
			details.setName(studentDetails.getName());
			studentDAO.save(details);
			return details;

		} else {
			throw new Exception(
					"Ther is noo recors existing in the system with that Id");
		}

	}
	
	public Student updateStudentByStudentId(StudentModel studentDetails,int studentId) throws Exception {

		Optional<Student> existingStudent = studentDAO.findById(studentId);

		if (existingStudent != null) {

			Student details = existingStudent.get();
			details.setName(studentDetails.getName());
			studentDAO.save(details);
			return details;

		} else {
			throw new Exception(
					"Ther is noo recors existing in the system with that Id");
		}

	}

	public void deleteStudent(StudentModel studentDetails) throws Exception {

		Optional<Student> existingStudent = studentDAO.findById(studentDetails
				.getStudentId());

		if (existingStudent != null) {

			Student details = existingStudent.get();

			studentDAO.delete(details);

		} else {
			throw new Exception(
					"Ther is noo recorsd existing in the system with that Id");
		}

	}

	public void deleteStudentById(int studentId) throws Exception {

		Optional<Student> existingStudent = studentDAO.findById(studentId);

		if (existingStudent != null) {

			Student details = existingStudent.get();

			studentDAO.delete(details);

		} else {
			throw new Exception(
					"Ther is noo recorsd existing in the system with that Id");
		}

	}

	public Student getStudentByname(String name) throws Exception {

		Student existingStudent = studentDAO.findStudentByName(name);

		if (existingStudent != null) {

			return existingStudent;

		} else {
			throw new Exception(
					"Ther is noo recorsd existing in the system with that Id");
		}

	}

	/*
	 * public Student getStudentByMobile(String mobile ) throws Exception {
	 * 
	 * Student existingStudent = studentDAO.findStudentByMobile(mobile);
	 * 
	 * if (existingStudent != null) {
	 * 
	 * return existingStudent;
	 * 
	 * } else { throw new Exception(
	 * "Ther is noo recorsd existing in the system with that Id"); }
	 * 
	 * }
	 */

}
