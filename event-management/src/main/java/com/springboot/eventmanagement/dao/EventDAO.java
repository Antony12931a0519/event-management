package com.springboot.eventmanagement.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.eventmanagement.entities.Event;

public interface EventDAO extends CrudRepository<Event, Long> {

}
