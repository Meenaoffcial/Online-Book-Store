package com.onlinebookstore.exception;

/**
 * Custom exception class for handling resource not found scenarios. This
 * exception is thrown when a requested resource (e.g., a book) does not exist
 * in the database.
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Constructor for ResourceNotFoundException.
	 *
	 * @param message The error message describing the resource that was not found.
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
