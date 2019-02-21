package com.customer.rest.action;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.customer.rest.action.controller.CustomerController;
import com.customer.rest.action.domain.Customer;
import com.customer.rest.action.exception.CustomerNotFoundException;
import com.customer.rest.action.service.CustomerService;
 
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	private static Log logger = LogFactory.getLog(CustomerControllerTest.class);
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerSerice;
	
	@Test
	public void found_CustomerListTest() throws Exception {
		
		BDDMockito.given(customerSerice.findAllCustomers()).willReturn(getMockedCustomers());
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/listCustomers"));
		MvcResult  mvcresult = result.andReturn();
		logger.info(" ********************  "+mvcresult.getResponse().getContentAsString());
		result.andExpect(MockMvcResultMatchers.status().isOk());
		result.andExpect(jsonPath("$[0].firstName", is("Ghulam")));
		
		
		
		
	}
	
	/*@Test
	public void found_CustomerTest() throws Exception {
		
		BDDMockito.given(customerSerice.findCustomer("rt")).willReturn(getMockedCustomer());
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/getCustomer"));
		MvcResult  mvcresult = result.andReturn();
		logger.info(getMockedCustomer().getFirstName()+" **********found_CustomerTest**********  "+mvcresult.getResponse().getContentAsString());
		result.andExpect(MockMvcResultMatchers.status().isOk());
		result.andExpect(MockMvcResultMatchers.jsonPath("firstName").value("Muhammad"));
		
		
		
	}*/
	
	
	@Test
	public void notFound_CustomerListTest()  {
		try {
		logger.info("*********************** notFound_CustomerListTest Unit Test ********************************");
		BDDMockito.given(customerSerice.findAllCustomers()).willThrow(new CustomerNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("/listCustomers"))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private List<Customer> getMockedCustomers(){
	
		List<Customer> list = new ArrayList<Customer>();
		
		Customer cust = new Customer("Ghulam","Abbas","unit 9 Auburn Park"); 
		list.add(cust);
		return list;
		
	}
	
	private Customer getMockedCustomer(){

		Customer customr = new Customer("Muhammad","Abbas","unit 9 Auburn Park"); 
		
		return customr;
		
	}

}
