package com.onlinebookstore.service.impl;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.exception.ResourceNotFoundException;
import com.onlinebookstore.repository.BookRepository;
import com.onlinebookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the BookService interface. Provides business logic for book
 * management operations.
 */
@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	/**
	 * Constructor-based dependency injection for BookRepository.
	 *
	 * @param bookRepository Repository for accessing book data.
	 */
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * Retrieves all books from the database.
	 *
	 * @return List of all books.
	 */
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	/**
	 * Retrieves a book by its unique ID.
	 *
	 * @param id The ID of the book.
	 * @return An Optional containing the book if found, otherwise empty.
	 */
	@Override
	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}

	/**
	 * Saves a new book to the database.
	 *
	 * @param book The book entity to be saved.
	 * @return The saved book entity.
	 */
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	/**
	 * Updates an existing book in the database.
	 *
	 * @param id          The ID of the book to be updated.
	 * @param bookDetails The updated details of the book.
	 * @return The updated book entity.
	 * @throws ResourceNotFoundException if the book is not found.
	 */
	@Override
	public Book updateBook(Long id, Book bookDetails) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

		book.setTitle(bookDetails.getTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setPrice(bookDetails.getPrice());
		book.setPublishedDate(bookDetails.getPublishedDate());
		book.setGenre(bookDetails.getGenre());

		return bookRepository.save(book);
	}

	/**
	 * Deletes a book from the database by its ID.
	 *
	 * @param id The ID of the book to be deleted.
	 * @throws ResourceNotFoundException if the book does not exist.
	 */
	@Override
	public void deleteBook(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new ResourceNotFoundException("Book not found with id: " + id);
		}
		bookRepository.deleteById(id);
	}
}
