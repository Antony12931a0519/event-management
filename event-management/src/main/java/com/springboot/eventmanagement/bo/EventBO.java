package com.springboot.eventmanagement.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.eventmanagement.dao.EventDAO;
import com.springboot.eventmanagement.entities.Event;

@Service
// @Component
public class EventBO {
	@Autowired
	EventDAO eventDAO;

	public List<Event> getEventList() {

		List<Event> events = (List<Event>) eventDAO.findAll();
		return events;
	}

}
