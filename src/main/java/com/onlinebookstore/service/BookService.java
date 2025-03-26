package com.onlinebookstore.service;

import com.onlinebookstore.entity.Book;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing books. Defines methods for performing CRUD
 * operations on Book entities.
 */
public interface BookService {

	/**
	 * Retrieves all books from the database.
	 *
	 * @return List of all books.
	 */
	List<Book> getAllBooks();

	/**
	 * Retrieves a book by its unique ID.
	 *
	 * @param id The ID of the book.
	 * @return An Optional containing the book if found, otherwise empty.
	 */
	Optional<Book> getBookById(Long id);

	/**
	 * Saves a new book to the database.
	 *
	 * @param book The book entity to be saved.
	 * @return The saved book entity.
	 */
	Book saveBook(Book book);

	/**
	 * Updates an existing book in the database.
	 *
	 * @param id          The ID of the book to be updated.
	 * @param bookDetails The updated details of the book.
	 * @return The updated book entity.
	 */
	Book updateBook(Long id, Book bookDetails);

	/**
	 * Deletes a book from the database by its ID.
	 *
	 * @param id The ID of the book to be deleted.
	 */
	void deleteBook(Long id);
}
