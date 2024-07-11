package com.project2.controler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project2.book.Book;
import com.project2.bookDao.BookDao;
import com.project2.customer.Customer;
import com.project2.service.CartService;

@Controller
public class CartController {
	
	 @Autowired
	    private CartService cartService;
	 @Autowired
	 private BookDao bookdao;
	    
	    @GetMapping("/cart")
	    public String getCartPage(Model model) {
	        model.addAttribute("cart", cartService.getCart());
	        return "cart";
	    }
	    @PostMapping("/cart")
		@ResponseBody
		public ModelAndView register(@ModelAttribute Book customer,Model model) {
			System.out.println(customer);
			model.addAttribute("cart",customer);
			bookdao.save(customer);
			return new ModelAndView("redirect:/cart");
		}
	    
//	    @PostMapping("/cart/remove/{bookId}")
//	    public String removeFromCart(@PathVariable Long bookId) {
//	        cartService.removeFromCart(bookId);
//	        return "redirect:/cart";
//	    }
	
}
