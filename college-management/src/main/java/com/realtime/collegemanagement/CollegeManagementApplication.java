package com.realtime.collegemanagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollegeManagementApplication {

	public final static Log logger = LogFactory
			.getLog(CollegeManagementApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementApplication.class, args);

	}

}
