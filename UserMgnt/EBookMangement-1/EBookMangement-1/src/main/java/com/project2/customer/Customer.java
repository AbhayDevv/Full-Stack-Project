package com.project2.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
  private String id;
  private String  name;
  private String email;
  private String password;
  private Integer mobile;
public Customer() {
	super();
}
public Customer(String id, String name, String email, String password, Integer mobile) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
}
public String getId() {
	return id;
}
public void setId(String id) {
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
			+ mobile + ", getId()=" + getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail()
			+ ", getPassword()=" + getPassword() + ", getMobile()=" + getMobile() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
}
