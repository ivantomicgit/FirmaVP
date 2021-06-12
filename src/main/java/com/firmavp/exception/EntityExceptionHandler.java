package com.firmavp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ApiErrorResponse >handleExceptionBadRequest(Exception exception){
		ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
		         .withStatus(HttpStatus.BAD_REQUEST)
		         .withError_code(HttpStatus.BAD_REQUEST.name())
		         .withMessage(exception.getLocalizedMessage())
		         .withDetail(exception.getMessage())
		         .build();
		  return new ResponseEntity<>(response, response.getStatus());
		
		
	}
	@ExceptionHandler
	public ResponseEntity<ApiErrorResponse>handleExceptionNotFound(ApiErrorResponse exception){
		ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
		         .withStatus(exception.getStatus())
		         .withError_code(exception.getStatus().name())
		         .withMessage(exception.getLocalizedMessage())
		         .withDetail(exception.getMessage())
		         .build();
		  return new ResponseEntity<>(response, response.getStatus());
		
	}
	

}
