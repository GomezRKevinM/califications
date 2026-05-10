package com.udc.app.califications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CalificationsApplication {

	static void main(String[] args) {
		SpringApplication.run(CalificationsApplication.class, args);
		System.out.println("Application Started in: http://localhost:9090/" );
	}

}
