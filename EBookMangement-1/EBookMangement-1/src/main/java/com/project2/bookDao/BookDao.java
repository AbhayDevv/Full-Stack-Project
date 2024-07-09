package com.project2.bookDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.book.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

}
