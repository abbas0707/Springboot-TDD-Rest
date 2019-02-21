package com.customer.rest.action.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rest.action.domain.Customer;
import com.customer.rest.action.domain.FaultDetail;
import com.customer.rest.action.exception.CustomerNotFoundException;
import com.customer.rest.action.service.CustomerService;

@RestController
public class CustomerController {
private static Log logger = LogFactory.getLog(CustomerController.class);	
@Autowired
private CustomerService customerSerice;

	/*
	 * Method resturns list of customers from JSON store.
	 * */
	@RequestMapping("/listCustomers")
	public List<Customer> getCustomers() throws Exception {	
		logger.info("************************* Request received for /listCustomers *****************************");
		
		List<Customer> customers = customerSerice.findAllCustomers();
		//logger.info("Response for /listCustomers, Total Customers: "+customers.size());
		return customers;
		
	}
	
	@RequestMapping("/getCustomer")
	public Customer getCustomer(String id) throws Exception {	
		logger.info("************************* Request received for /getCustomer *****************************");
		
		Customer customer = customerSerice.findCustomer(id);
		//logger.info("Response for /listCustomers, Total Customers: "+customers.size());
		return customer;
		
	}
	
	

}
