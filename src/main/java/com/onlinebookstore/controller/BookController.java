package com.onlinebookstore.controller;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for handling book-related operations. Provides endpoints for
 * CRUD operations on books.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	/**
	 * Constructor for BookController.
	 * 
	 * @param bookService The service layer handling business logic for books.
	 */
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * Retrieves all books from the database.
	 * 
	 * @return List of all books.
	 */
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	/** 
	 * Retrieves a book by its ID.
	 *  
	 * @param id The ID of the book to fetch.
	 * @return The book details if found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Long id) {
	    Book book = bookService.getBookById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
	    return ResponseEntity.ok(book);
	}


	/**
	 * Adds a new book to the database.
	 * 
	 * @param book The book object to be added.
	 * @return The saved book with a generated ID.
	 */
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}

	/**
	 * Updates an existing book by its ID.
	 * 
	 * @param id          The ID of the book to update.
	 * @param bookDetails The updated book details.
	 * @return The updated book.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
		Book updatedBook = bookService.updateBook(id, bookDetails);
		return ResponseEntity.ok(updatedBook);
	}

	/**
	 * Deletes a book by its ID.
	 * 
	 * @param id The ID of the book to delete.
	 * @return A success message.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok("Book deleted successfully");
	}
}
