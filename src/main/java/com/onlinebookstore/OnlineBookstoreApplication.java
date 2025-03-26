package com.onlinebookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Online Bookstore application. This class initializes
 * and runs the Spring Boot application.
 */
@SpringBootApplication
public class OnlineBookstoreApplication {

	/**
	 * The main method that starts the Spring Boot application.
	 * 
	 * @param args Command-line arguments passed during application startup.
	 */
	public static void main(String[] args) {
		SpringApplication.run(OnlineBookstoreApplication.class, args);
	}
}
