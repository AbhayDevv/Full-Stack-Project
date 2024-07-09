package com.project2.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project2.custDao.CustomerDao;
import com.project2.customer.Customer;

@Controller
public class CustomerControler {
	@Autowired
	private CustomerDao customerdao;
	

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	@GetMapping("/loginapp")
	public String login(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "loginapp";
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		Customer customer = customerdao.findByEmail(email);
		if (customer != null && customer.getPassword().equals(password)) {
			return new ModelAndView("redirect:/index");
		} else {
			model.addAttribute("error", "Invalid email or password");
			return new ModelAndView("redirect:/loginapp");
		}

	}
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

}
