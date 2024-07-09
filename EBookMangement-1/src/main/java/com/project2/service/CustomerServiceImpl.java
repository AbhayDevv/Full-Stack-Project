//package com.project2.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project2.custDao.CustomerDao;
//import com.project2.customer.Customer;
//@Service
//public class CustomerServiceImpl implements CustomerService {
//     @Autowired
//	private CustomerDao  customerDao;
//	
//	List<Customer> list;
//	@Override
//	public List<Customer> getCustomer() {
//		// TODO Auto-generated method stub
//		return customerDao.findAll();
//	}
//	
//	@Override
//	public Customer getCustomer(int customerId) {
//		// TODO Auto-generated method stub
//		return customerDao.getOne(customerId);
//	}
//
//	@Override
//	public Customer addCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		customerDao.save(customer);
//		return customer;
//	}
//
//	@Override
//	public Customer putCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		customerDao.save(customer);
//		return customer;
//	}
//
//	@Override
//	public void deleteCustomer(int parseInt) {
//		// TODO Auto-generated method stub
//		Customer entity=customerDao.getOne(parseInt);
//		customerDao.delete(entity);
//	}
//	
//
//}
