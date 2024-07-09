package com.project2.customer;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;


@Entity
public class Customer {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "customer_id")
	private Long id;
  private String  name;
  private String email;
  private String password;
  private Integer mobile;
  
  
public Customer() {
	super();
}


public Customer(Long id, String name, String email, String password, Integer mobile) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public Integer getMobile() {
	return mobile;
}


public void setMobile(Integer mobile) {
	this.mobile = mobile;
}


@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
			+ mobile + "]";
}
}
