package com.gs.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentserviceApplication {

	// MVC Pattern
	// M---> Model
	// V---> View
	// C ---> Controller

	// Dispatcher Servlet
	// syc
	//async procces

	// ----> controller ---> Service---> Repo layer
//      <--- Controller <--- Service <--- Repo layer

	public static void main(String[] args) {
		SpringApplication.run(StudentserviceApplication.class, args);
	}

}
