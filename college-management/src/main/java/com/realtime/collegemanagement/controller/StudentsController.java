package com.realtime.collegemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.collegemanagement.bo.StudentNamesBO;
import com.realtime.collegemanagement.entities.StudentNames;

@RestController
// boiler plate code
public class StudentsController {

	@Autowired
	StudentNamesBO studentNamesBO;

	@RequestMapping(value = "/", produces = "application/json", method = { RequestMethod.GET })
	public String getWelcomeMessage() {

		return "Hello!";

	}

	@RequestMapping(value = "/student/list", produces = "application/json", method = { RequestMethod.GET })
	public List<StudentNames> getStudentList() {

		return studentNamesBO.getStudentList();

	}

	@RequestMapping(value = "/student/count", produces = "application/json", method = { RequestMethod.GET })
	public String getStudentCount() {

		return "The count of student in db is :"
				+ studentNamesBO.getCountOfStudent();

	}

	@RequestMapping(value = "/student/add",
			produces = "application/json",
			consumes = "application/json",
			method = { RequestMethod.POST })
	public StudentNames inserttudentDetails(@RequestBody StudentNames studentNames) {

		return studentNamesBO.insertStudentDetails(studentNames);

	}
	
	@RequestMapping(value = "/student/update",
			produces = "application/json",
			consumes = "application/json",
			method = { RequestMethod.PUT })
	public StudentNames updateStudentDetails(@RequestBody StudentNames studentNames) throws Exception {

		return studentNamesBO.updateStudentDetails(studentNames);

	}

}
