package com.onlinebookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling application-wide exceptions. This class
 * provides a centralized way to handle errors and format responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Handles all generic exceptions in the application.
	 *
	 * @param ex The exception that occurred.
	 * @return A structured JSON response containing error details.
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
		// Create a map to store error details
		Map<String, Object> errorResponse = new HashMap<>();

		// Add the current timestamp in ISO format
		errorResponse.put("timestamp", DateTimeFormatter.ISO_INSTANT.format(Instant.now()));

		// Add the exception message
		errorResponse.put("message", ex.getMessage());

		// Add the HTTP status code
		errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

		// Return a structured error response with HTTP 500 status
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
