package com.springboot.eventmanagement.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@RequestMapping(value = "/",
			produces = "application/json",
			method = { RequestMethod.GET })
	@ResponseBody
	public String showWelcomeMessage(){
		
		return "Hello!!!!  Good Morning.";
	}
	
	@RequestMapping(value = "/date",
			produces = "application/json",
			method = { RequestMethod.GET })
	@ResponseBody
	public String showError(){
		
		return "Hello!!!!  Good Morning."+"Todays date is :"+new Date();
	}

}
