package com.springboot.eventmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.eventmanagement.bo.EventBO;
import com.springboot.eventmanagement.entities.Event;

@RestController
public class DefaultController {

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

}
