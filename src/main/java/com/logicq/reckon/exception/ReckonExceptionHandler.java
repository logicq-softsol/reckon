package com.logicq.reckon.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.logicq.reckon.utils.ReckonDateUtils;

@ControllerAdvice
public class ReckonExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	ReckonDateUtils reckonDateUtils;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(reckonDateUtils.currentDate(), ex.getMessage(), request.getDescription(false),
				ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
