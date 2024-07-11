package com.project2.custDao;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project2.customer.Customer;




@Repository
public interface CustomerDao  extends CrudRepository<Customer, Long>{
	
	
	 Optional<Customer> findByEmail(String email);
	
}
