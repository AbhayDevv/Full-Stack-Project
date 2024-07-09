package com.project2.custDao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project2.customer.Customer;




@Repository
public interface CustomerDao  extends CrudRepository<Customer, Long>{
	Customer findByEmail(String email);
	
}
