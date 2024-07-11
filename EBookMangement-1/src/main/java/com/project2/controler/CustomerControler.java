package com.project2.controler;


import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project2.custDao.CustomerDao;
import com.project2.customer.Customer;
import com.project2.service.BookServiceImpl;

@Controller
public class CustomerControler {
	@Autowired
	private CustomerDao customerdao;
	@Autowired
	private BookServiceImpl bookservice;

	//LOGIN METHODS 

	@GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new Customer());
        return "login";
    }
    
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("user") Customer user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // handle validation errors
            return "login";
        }
        Optional<Customer> existingUser = customerdao.findByEmail(user.getEmail());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(user.getPassword())) {
            // login successful, redirect to dashboard
            return "redirect:/home";
        } else {
            // login failed, show error message
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
 
	
	
	
	//REGISTRATION METHODS 
	@GetMapping("/registeration")
	public String registeration(Customer customer) {

		return "registerapp";
	}

	
	@PostMapping("/register")
	@ResponseBody
	public ModelAndView register(@ModelAttribute Customer customer,Model model) {
		System.out.println(customer);
		model.addAttribute("cust",customer);
		customerdao.save(customer);
		return new ModelAndView("redirect:/home");
	}
	
	
//HOME PAGE BOOK DISPLAY METHOD	
	
	@GetMapping("/home")
	public String getlist(@ModelAttribute Book book, Model model) {
		System.out.println();
	List<com.project2.book.Book> listBook = bookservice.getBook();
	model.addAttribute("books", listBook);
		return "home";
	}
	@GetMapping("/home/{id}")
    public String getBookDetails(@PathVariable Long id, Model model) {
        com.project2.book.Book book = bookservice.getBook(id);
        List<com.project2.book.Book> relatedBooks = bookservice.getRelatedBooks(book);

        model.addAttribute("book", book);
        model.addAttribute("relatedBooks", relatedBooks);

        return "bookById";
    }
	

}
