package com.customer.rest.action.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rest.action.dao.CustomerRespositry;
import com.customer.rest.action.domain.Customer;

@Service
public class CustomerService {
	
@Autowired	
private CustomerRespositry customerRepo;	


public List<Customer> findAllCustomers() throws Exception {
	
	return customerRepo.findAll();
}


public Customer findCustomer(String id) throws Exception {
	
	Customer cust =  new Customer("Muhammad","Musa","Sydney - AU");
	
	return cust;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
