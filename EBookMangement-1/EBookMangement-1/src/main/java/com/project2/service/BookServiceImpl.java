package com.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.book.Book;
import com.project2.bookDao.BookDao;
import com.project2.custDao.CustomerDao;
import com.project2.customer.Customer;


@Service
public class BookServiceImpl implements BookService{
    @Autowired
	private BookDao bookdao;
	List<Book> list;
	@Override
	public List<Book> getBook() {
		// TODO Auto-generated method stub
		return bookdao.findAll();
	}


	@Override
	public Book getBook(int bookId) {
		// TODO Auto-generated method stub
		return bookdao.getOne(bookId);
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
	public void deleteBook(int parseInt) {
		// TODO Auto-generated method stub
		Book entity=bookdao.getOne(parseInt);
		bookdao.delete(entity);
	}

}
