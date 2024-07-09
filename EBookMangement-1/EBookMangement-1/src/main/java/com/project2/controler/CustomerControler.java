package com.project2.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project2.custDao.CustomerDao;
import com.project2.customer.Customer;

@Controller
public class CustomerControler {
	@Autowired
	private CustomerDao customerdao;

	@GetMapping("/login")
	public String login(Model model) {
		Customer customer = new Customer();
		model.addAttribute("user", customer);
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		Customer customer = customerdao.findByEmail(email);
		if (customer != null && customer.getPassword().equals(password)) {
			return "redirect:/index";
		} else {
			model.addAttribute("error", "Invalid email or password");
			return "login";
		}

	}
}
