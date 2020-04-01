/**
 * 
 */
package com.star.gift.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.star.gift.utility.ErrorConstants;

/**
 * @author User1
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> error(OrderNotFoundException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstants.ORDER_NOT_FOUND_CODE);
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}


	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorResponse> error(ProductException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstants.NO_RECORD_FOUND_CODE);
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}
}
