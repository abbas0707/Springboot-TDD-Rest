package com.customer.rest.action;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.AssertFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.customer.rest.action.domain.Customer;
import com.customer.rest.action.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerRestClientTests {
	private static Log logger = LogFactory.getLog(CustomerRestClientTests.class);
	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void found_customerList() {
		logger.info("***found_customerList Unit Test ***");
		try {		
			ResponseEntity<ArrayList> response = restTemplate.getForEntity("/listCustomers", ArrayList.class);
			//logger.info("*** found_customerList response body  ***" + response.getBody().get(0));
			String expected = "{firstName=Adam, lastName=George, address=5/7 Denman Ave 3436}";
			
			assertThat(response.getStatusCode(),is(HttpStatus.OK));
			//assertThat(response.getBody().get(0),is(expected));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Customer> getMockedCustomer() {
		List<Customer> list = new ArrayList<Customer>();
		Customer cust = new Customer("Ghulam", "Abbas", "unit 9 Auburn Park");
		list.add(cust);
		return list;

	}
}
