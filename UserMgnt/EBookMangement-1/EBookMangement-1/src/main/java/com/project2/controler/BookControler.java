package com.project2.controler;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project2.bookDao.BookDao;
import com.project2.service.BookService;

@Controller
public class BookControler {
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private BookDao bookdao;

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	

	@GetMapping("/register")
	public String getRegister() {
		return "register";
	}

//	@GetMapping("/stud")
//	public String getEmployee(@ModelAttribute Book book, Model model) {
//		System.out.println(book);
//		List<com.project2.book.Book> listBook = bookservice.getBook();
//		model.addAttribute("book", listBook);
//		return "books";
//	}
	@GetMapping("/list")
	public String getlist(@ModelAttribute Book book, Model model) {
		System.out.println();
	List<com.project2.book.Book> listBook = bookservice.getBook();
	model.addAttribute("books", listBook);
		return "books";
//		
//	}
//	@GetMapping("/UploadImage")
//	public String addBook(Model model) {
//		model.addAttribute("books", new Book());
//		return "self";
//	}
//	@PostMapping("/UploadImage")
//	public String addBook(@ModelAttribute com.project2.book.Book book,@RequestParam("image") MultipartFile image) {
//		try {
//			byte[] imageData = image.getBytes();
//			book.setImage(imageData);
//			bookservice.addBook(book);
//			return "redirect:/books";	
//		}catch(Exception e) {
//			return "self";
//		}
//	}
//	@GetMapping("/books")
//	public String getBooks(Model model) {
//		model.addAttribute("books", bookdao.findAll());
//		return "books";
//	}
//	@GetMapping("/getImage/{id}")
//	public ResponseEntity<byte[]> getImage(@PathVariable Integer id){
//		com.project2.book.Book book=bookdao.findById(id).orElseThrow();
//		byte[] imageData=book.getImage();
//		HttpHeaders headers=new HttpHeaders();
//		headers.setContentType(MediaType.valueOf("image/png"));
//		return new ResponseEntity<>(imageData,headers,HttpStatus.OK);
//		
//	}

}
}
