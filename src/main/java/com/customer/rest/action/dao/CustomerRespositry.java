package com.customer.rest.action.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.customer.rest.action.domain.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class CustomerRespositry {
	
	private static Log logger = LogFactory.getLog(CustomerRespositry.class);

	public static List<Customer> findAll() throws  Exception {
			ObjectMapper mapper = new ObjectMapper();				
		TypeReference<List<Customer>> typeReference = new TypeReference<List<Customer>>(){};
		InputStream inputStream = new FileInputStream( ResourceUtils.getFile("classpath:data/customers.json").getPath());	
		
		List<Customer> custList  = mapper.readValue(inputStream,typeReference);
		
		custList.forEach(action  -> logger.info("First name : "+action.getFirstName()));
		
		return custList;
			
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CustomerRespositry.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			File file = ResourceUtils.getFile("classpath:data/customers.json");
			
				System.out.println(file.getCanonicalPath());
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}

}
