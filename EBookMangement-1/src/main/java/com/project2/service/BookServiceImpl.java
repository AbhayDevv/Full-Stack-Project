package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.book.Book;
import com.project2.bookDao.BookDao;



@Service
public class BookServiceImpl implements BookService{
    @Autowired
	private BookDao bookdao;
	List<Book> list;
	
	 public List<Book> getRelatedBooks(Book book) {
	        // Assuming related books are fetched based on some criteria, e.g., same author or genre
	        return bookdao.findRelatedBooks(book.getAuthor());
	    }
	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return bookdao.findAll();
	}


	@Override
	public Book getBook(Long Id) {
		// TODO Auto-generated method stub
		return bookdao.findById(Id).orElse(null);
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.save(book);
		return book;
	}

	@Override
	public Book putBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.save(book);
		return book;
	}

	@Override
	public void deleteBook(Long parseInt) {
		// TODO Auto-generated method stub
		//Book entity=bookdao.getOne(parseInt);
		//bookdao.delete(entity);
	}

}
