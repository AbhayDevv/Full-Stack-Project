package com.project2.bookDao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project2.book.Book;

public interface BookDao extends JpaRepository<Book, Long> {
	@Query("SELECT b FROM Book b WHERE b.author = ?1")
	List<Book> findRelatedBooks(String author);
	
	 @Query("SELECT b FROM Book b WHERE b.id = :bookId")
	    Book findBookById(@Param("bookId") Long bookId);
	
}
