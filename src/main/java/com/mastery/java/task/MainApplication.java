package com.mastery.java.task;

import com.mastery.java.task.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

	public static void main(String[] args) {
		log.info("Starting app");
		SpringApplication.run(MainApplication.class, args);

		log.info("Creating Database");
	}

}
