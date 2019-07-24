package com.realtime.collegemanagement.bo;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.realtime.collegemanagement.dao.StudentDAO;
import com.realtime.collegemanagement.entities.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentBOTest {

	@InjectMocks
	StudentBO studentBO;

	@Mock
	StudentDAO studentDAO;

	@Before
	public void segtUp() {

		MockitoAnnotations.initMocks(this);
	}

	@After
	public void cleanUp() {

		studentBO = null;
		studentDAO = null;
	}

	@Test
	public void getStudentListTest() {

		List<Student> students = new ArrayList<Student>();

		Student s = new Student();
		s.setAddress("skfnak");
		s.setMobile("ajfhiqa");
		s.setName("khw");
		s.setStudentId(1);
		students.add(s);

		Mockito.when(studentDAO.findAll()).thenReturn(students);

		studentBO.getStudentList();
	}

	@Test
	public void createStudentTest() {

		Student s = new Student();
		s.setAddress("skfnak");
		s.setMobile("ajfhiqa");
		s.setName("khw");
		s.setStudentId(1);

		Mockito.when(studentDAO.save(s)).thenReturn(s);

		studentBO.getStudentList();
	}

}
