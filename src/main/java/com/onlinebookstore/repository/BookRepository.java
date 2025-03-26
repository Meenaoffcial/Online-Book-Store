package com.onlinebookstore.repository;

import com.onlinebookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Book entities. Extends JpaRepository to
 * provide CRUD operations and database interaction.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	// No additional methods required as JpaRepository provides built-in CRUD
	// operations
}
