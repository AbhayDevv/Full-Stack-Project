package com.project2.service;

import java.util.List;

import com.project2.book.Book;


public interface BookService  {
	public List<Book> getBook();

	public Book getBook(int bookId);

	public Book addBook(Book book);

	public Book putBook(Book book);

	public void deleteBook(int parseInt);
}
