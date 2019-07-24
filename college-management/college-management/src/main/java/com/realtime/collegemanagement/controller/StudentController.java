package com.realtime.collegemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.collegemanagement.bo.StudentBO;
import com.realtime.collegemanagement.entities.Student;
import com.realtime.collegemanagement.models.StudentModel;

@RestController
public class StudentController {

	@Autowired
	private StudentBO studentBO;

	@RequestMapping(value = "/college/student/list", produces = "application/json", method = { RequestMethod.GET })
	@ResponseBody
	public List<StudentModel> getStudentList() {

		List<StudentModel> studentList = studentBO.getStudentList();

		return studentList;

	}

	@RequestMapping(value = "/welcome", produces = "application/json", method = { RequestMethod.GET })
	@ResponseBody
	public String showWelcomeMessage() {

		return "hello";

	}

	@RequestMapping(value = "/college/student/unique", produces = "application/json", method = { RequestMethod.GET })
	@ResponseBody
	public List<String> getStudentsByUniqueName() {

		List<String> studentList = studentBO.getStudentsByUniqueName();

		return studentList;

	}

	@RequestMapping(value = "/college/student/add", produces = "application/json", consumes = "application/json", method = { RequestMethod.POST })
	@ResponseBody
	public Student createStudent(@RequestBody StudentModel student) {

		Student studentDeails = studentBO.creatStudent(student);

		return studentDeails;

	}

	@RequestMapping(value = "/college/student/update", produces = "application/json", consumes = "application/json", method = { RequestMethod.PUT })
	@ResponseBody
	public Student updteStudent(@RequestBody StudentModel student)
			throws Exception {

		Student studentDeails = studentBO.updateStudent(student);

		return studentDeails;

	}

	@RequestMapping(value = "/college/student/update/{studentId}", produces = "application/json", consumes = "application/json", method = { RequestMethod.PUT })
	@ResponseBody
	public Student updteStudentByStudentId(@RequestBody StudentModel student,
			@PathVariable("studentId") int studentId) throws Exception {

		Student studentDeails = studentBO.updateStudentByStudentId(student,
				studentId);

		return studentDeails;

	}

	@RequestMapping(value = "/college/student/delete", produces = "application/json", consumes = "application/json", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteStudent(@RequestBody StudentModel student)
			throws Exception {

		studentBO.deleteStudent(student);

	}

	@RequestMapping(value = "/college/student/deleteById/{studentId}", produces = "application/json", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteStudentById(@PathVariable("studentId") int studentId)
			throws Exception {
		// method overloading
		studentBO.deleteStudentById(studentId);

	}

	@RequestMapping(value = "/college/student/deleteByQueryId", produces = "application/json", consumes = "application/json", method = { RequestMethod.DELETE })
	@ResponseBody
	public void deleteStudentByQueryId(@RequestParam("studentId") int studentId)
			throws Exception {
		// method overloading
		studentBO.deleteStudentById(studentId);

	}

	@RequestMapping(value = "/college/student", produces = "application/json",
	// consumes = "application/json",
	method = { RequestMethod.GET })
	@ResponseBody
	public Student searchStudentByName(@RequestParam("name") String name)
			throws Exception {
		return studentBO.getStudentByname(name);
	}

	/*
	 * @RequestMapping(value = "/college/studentdetails", produces =
	 * "application/json", consumes = "application/json", method = {
	 * RequestMethod.GET })
	 * 
	 * @ResponseBody public Student
	 * deleteStudentByMobile(@RequestParam("mobile") String mobile) throws
	 * Exception { return studentBO.getStudentByMobile(mobile); }
	 */

}
