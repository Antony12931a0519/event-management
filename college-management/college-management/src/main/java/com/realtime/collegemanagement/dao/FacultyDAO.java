package com.realtime.collegemanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.realtime.collegemanagement.entities.Faculty;

public interface FacultyDAO extends CrudRepository<Faculty, Integer> {

}
