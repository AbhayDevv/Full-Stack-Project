package com.project2.book;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
//@Table(name = "booook\\")
public class Book {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "book_id")
	private Long id;
	private String title;
	private String author;
	private double price;
	private String language;
	private int pages;
	private String publisher;
	private String discription;
	private String photoUrl;
	
	public Book() {
		super();
	}

	

	public Book(Long id, String title, String author, double price, String language, int pages, String publisher,
			String discription, String photoUrl) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.language = language;
		this.pages = pages;
		this.publisher = publisher;
		this.discription = discription;
		this.photoUrl = photoUrl;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long bookId) {
		this.id = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "Book [Id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", language="
				+ language + ", pages=" + pages + ", publisher=" + publisher + ", discription=" + discription
				+ ", photoUrl=" + photoUrl + "]";
	}
	
}
