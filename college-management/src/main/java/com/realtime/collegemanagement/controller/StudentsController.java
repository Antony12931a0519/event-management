package com.realtime.collegemanagement.controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@ApiOperation("this is mean for getting the list of students from the db.")
	@RequestMapping(value = "/student/list", produces = "application/json", method = { RequestMethod.GET })
	public List<StudentNames> getStudentList() {

		return studentNamesBO.getStudentList();

	}

	@RequestMapping(value = "/student/count", produces = "application/json", method = { RequestMethod.GET })
	public String getStudentCount() {

		return "The count of student in db is :"
				+ studentNamesBO.getCountOfStudent();

	}

	@RequestMapping(value = "/student/add", produces = "application/json", consumes = "application/json", method = { RequestMethod.POST })
	public StudentNames inserttudentDetails(
			@RequestBody StudentNames studentNames) {

		return studentNamesBO.insertStudentDetails(studentNames);

	}

	@RequestMapping(value = "/student/update", produces = "application/json", consumes = "application/json", method = { RequestMethod.PUT })
	public StudentNames updateStudentDetails(
			@RequestBody StudentNames studentNames) throws Exception {

		return studentNamesBO.updateStudentDetails(studentNames);

	}
	
	@RequestMapping(value = "/student/update/{StudentId}",
			produces = "application/json",
			consumes = "application/json",
			method = { RequestMethod.PUT })
	public StudentNames updateStudentDetailsByStudentId(
			@PathVariable("StudentId") int studentId) throws Exception {

		return studentNamesBO.updateStudentDetailsByStudentId(studentId);

	}
	
	@RequestMapping(value = "/student/update/ids",
			produces = "application/json",
			consumes = "application/json",
			method = { RequestMethod.PUT })
	public StudentNames updateStudentDetailsByStudentId(
			@RequestParam("ids") String studentIds) throws Exception {
		
		StudentNames result = null;
		
		if(studentIds != null){
			
			String[] ids = studentIds.split(",");
			
			for(String id : ids){
				result = studentNamesBO.updateStudentDetailsByStudentId(Integer.parseInt(id));
			}
		}
		return result;

		

	}


	@RequestMapping(value = "/student/delete", produces = "application/json", consumes = "application/json", method = { RequestMethod.DELETE })
	public String deleteStudentDetails(@RequestBody StudentNames studentNames)
			throws Exception {

		return studentNamesBO.deleteStudentDetails(studentNames);

	}

}
