package com.project2.controler;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.project2.book.Cart;
import com.project2.bookDao.CartDao;
import com.project2.customer.Customer;
import com.project2.service.BookServiceImpl;
import com.project2.service.CartService;

@Controller
public class CartController {
	@Autowired
	private BookServiceImpl bookservice;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartDao cartdao;

//	@GetMapping("/add")
//	public String getCart(Model model,@ModelAttribute Book book) {
//		List<com.project2.book.Book> carts = bookservice.getBook();
//		model.addAttribute("carts", carts);
//		return "cart";
//	}
	@GetMapping("/add")
	public String login(Model model) {
		Book cart = new Book();
		model.addAttribute("carts", cart);
		return "cart";
	}
	@PostMapping("/add/{id}")
	@ResponseBody
	public ModelAndView register(@ModelAttribute Cart customer,Model model) {
		System.out.println(customer);
		model.addAttribute("carts",customer);
		cartdao.save(customer);
		return new ModelAndView("redirect:/cart");
	}


//	    @PostMapping("/add/{id}")
//	    public String addToCart(@PathVariable Long id) {
//		cartService.addToCart(id);
//		
//		return "redirect:/cart"; // redirect to the cart page }
//	}

	
}
