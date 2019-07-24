package com.realtime.collegemanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.realtime.collegemanagement.entities.Event;

public interface EventDAO extends CrudRepository<Event,Long> {

}
