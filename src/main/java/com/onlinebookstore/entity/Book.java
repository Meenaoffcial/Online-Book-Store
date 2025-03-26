package com.onlinebookstore.entity;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Entity class representing a Book in the Online Bookstore. This class maps to
 * the "books" table in the database.
 */
@Entity
@Table(name = "books")
public class Book {

	/**
	 * Primary key for the book entity. Auto-generated using IDENTITY strategy.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Title of the book. This field is required (NOT NULL).
	 */
	@Column(nullable = false)
	private String title;

	/**
	 * Author of the book. This field is required (NOT NULL).
	 */
	@Column(nullable = false)
	private String author;

	/**
	 * Price of the book. This field is required (NOT NULL).
	 */
	@Column(nullable = false)
	private Double price;

	/**
	 * Published date of the book. Stored as a DATE type in the database. Uses JSON
	 * format "yyyy-MM-dd" for proper serialization.
	 */
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date publishedDate;

	/**
	 * Genre of the book (e.g., Fiction, Non-fiction, Science, etc.). This field is
	 * required (NOT NULL).
	 */
	@Column(nullable = false)
	private String genre;

	/**
	 * Default constructor required by JPA.
	 */
	public Book() {
	}

	/**
	 * Parameterized constructor to create a book object.
	 * 
	 * @param title         Title of the book.
	 * @param author        Author of the book.
	 * @param price         Price of the book.
	 * @param publishedDate Published date of the book.
	 * @param genre         Genre of the book.
	 */
	public Book(String title, String author, Double price, Date publishedDate, String genre) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishedDate = publishedDate;
		this.genre = genre;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
