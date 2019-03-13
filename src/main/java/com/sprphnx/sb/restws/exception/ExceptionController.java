package com.sprphnx.sb.restws.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception{
		BaseExcetionResponse baseExcetionResponse = 
				new BaseExcetionResponse(new Date(), "ERR-100", "Generic exception", "Contact support");
		return new ResponseEntity<>(baseExcetionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException, WebRequest request) throws Exception{
		BaseExcetionResponse baseExcetionResponse = 
				new BaseExcetionResponse(new Date(), userNotFoundException.getCode(), userNotFoundException.getMessage(), userNotFoundException.getDetails());
		return new ResponseEntity<>(baseExcetionResponse,HttpStatus.NOT_FOUND);
	}
	
}
