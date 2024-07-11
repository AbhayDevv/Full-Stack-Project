package com.project2.controler;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project2.customer.Customer;
import com.project2.service.BookServiceImpl;
import com.project2.service.CartService;

@Controller
public class BookControler {
	@Autowired
	private BookServiceImpl bookservice;
	@Autowired
	private CartService cartservice;

	//Adding book detail to single page
	@GetMapping("/books")
	public String getlist(@ModelAttribute Book book, Model model) {
		System.out.println();
	List<com.project2.book.Book> listBook = bookservice.getBook();
	model.addAttribute("books", listBook);
		return "books";
	}
	@GetMapping("/book/{bookId}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        com.project2.book.Book book = bookservice.getBook(id);
        List<com.project2.book.Book> relatedBooks = bookservice.getRelatedBooks(book);

        model.addAttribute("book", book);
        model.addAttribute("relatedBooks", relatedBooks);

        return "bookById";
    }
	@PostMapping("/books/{bookId}/add-to-cart")
    public String addToCart(@PathVariable Long bookId) {
		cartservice.addToCart(bookId);
        return "redirect:/cart";
    }

	
	//Method for Adding New Book
	@GetMapping("/NewRegist")
	public String registeration(Customer customer) {

		return "bookregister";
	}

	
	@PostMapping("/newRegister")
	@ResponseBody
	public ModelAndView register(@ModelAttribute com.project2.book.Book book,Model model) {
		System.out.println(book);
		model.addAttribute("book1",book);
		bookservice.addBook(book);
		return new ModelAndView("redirect:/home");
	}
}

