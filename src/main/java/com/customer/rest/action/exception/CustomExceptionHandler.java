package com.customer.rest.action.exception;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.customer.rest.action.domain.FaultDetail;
 
@ControllerAdvice
@RestController
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {
	private static Log logger = LogFactory.getLog(CustomExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<FaultDetail> handleAllExceptions(Exception ex, WebRequest request) {	 
		logger.error("Exception occured for "+request.getDescription(false)+", "+ex.getMessage());
		FaultDetail errorDetails = new FaultDetail(new Date(), ex.getMessage(),
	      request.getDescription(false));		
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private  void CustomerNotFoundExceptionHandle(CustomerNotFoundException ex) throws Exception {
		
		logger.error(" #################### Inside  CustomerNotFoundExceptionHandle ");
			
			
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
