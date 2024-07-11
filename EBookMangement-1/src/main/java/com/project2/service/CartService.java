
package com.project2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.book.Book;
import com.project2.bookDao.BookDao;
import com.project2.custDao.CustomerDao;
import com.project2.customer.Customer;

@Service
public class CartService {
	
	 @Autowired
	 private BookDao bookDao;
	 
	
	    private List<Book> cart = new ArrayList<>();
	    
	    public void addToCart(Long bookId) {
	        Book book = bookDao.findBookById(bookId);
	        if (book!= null) {
	            cart.add(book);
	        }
	    }
	    
//	    public void removeFromCart(Long bookId) {
//	        cart.removeIf(book -> book.getId().equals(bookId));
//	    }
	    
	    public List<Book> getCart() {
	        return cart;
	    }
	 
//	    
//	    public void addToCart(Long id) {
//	    	 Book book = bookDao.findById(id).orElseThrow();
//	         // create a new cart object
//	         Cart cart = new Cart();
//	         cart.setTitle(book.getTitle());
//	         cart.setAuthor(book.getAuthor());
//	         cart.setPrice(book.getPrice());
//	         // save the cart to the database
//	         cartRepository.save(cart);
//	}
}
