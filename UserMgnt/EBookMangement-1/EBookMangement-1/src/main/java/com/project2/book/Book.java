package com.project2.book;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer bookId;
	private String title;
	private String author;
	private String ratingCount;
	private double price;
	private String publisher;
	private String discription;
	private byte[] image;
	private Integer pages;
	
	public Book() {
		super();
	}
	public Book(Integer bookId, String title, String author, String ratingCount, double price, String publisher,
			String discription, Integer pages, byte[] image) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.ratingCount = ratingCount;
		this.price = price;
		this.publisher = publisher;
		this.discription = discription;
		this.pages = pages;
		this.image = image;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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
	public String getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(String ratingCount) {
		this.ratingCount = ratingCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", ratingCount=" + ratingCount
				+ ", price=" + price + ", publisher=" + publisher + ", discription=" + discription + ", pages=" + pages
				+ ", image=" + Arrays.toString(image) + "]";
	}
	
}
