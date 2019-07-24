package com.realtime.collegemanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.realtime.collegemanagement.bo.EventBO;
import com.realtime.collegemanagement.entities.Event;

@RestController
public class EventController {

	@Autowired
	EventBO eventBO;

	@RequestMapping(value = "/", produces = "application/json", method = { RequestMethod.GET })
	@ResponseBody
	public String showWelcomeMessage() {

		return "Hello!!!!  Good Morning.";
	}

	@RequestMapping(value = "/date", produces = "application/json", method = { RequestMethod.GET })
	@ResponseBody
	public String showError() {

		return "Hello!!!!  Good Morning." + "Todays date is :" + new Date();
	}

	@RequestMapping(value = "/events/list", produces = "application/json", method = { RequestMethod.GET })
	@ResponseBody
	public List<Event> getEventsList() {

		return eventBO.getEventList();
	}

	@RequestMapping(value = "/events/add", produces = "application/json", consumes = "application/json", method = { RequestMethod.POST })
	@ResponseBody
	public String getEventsList(@RequestBody Event event) {

		event = eventBO.createStudent(event);

		if (event != null)
			return "event details are ceated sucessfully.";
		else
			return "event details are not ceated sucessfully.";
	}

	@RequestMapping(value = "/events/update", produces = "application/json", consumes = "application/json", method = { RequestMethod.PUT })
	@ResponseBody
	public Event updateEvent(@RequestBody Event event) {

		event = eventBO.updateEvent(event);

		if (event != null)
			return event;
		else
			return null;
	}

	@RequestMapping(value = "/events/delete",
			produces = "application/json",
			consumes = "application/json",
			method = { RequestMethod.DELETE })
	@ResponseBody
	public String deleteEvent(@RequestBody Event event) {

		String result = eventBO.deleteEvent(event);

		if (result != null)
			return result;
		else
			return null;
	}

}
