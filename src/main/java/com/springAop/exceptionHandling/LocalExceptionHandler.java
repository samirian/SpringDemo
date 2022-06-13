package com.springAop.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LocalExceptionHandler {
	@ExceptionHandler({CustomException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> handleException(RuntimeException exception) {
		return ResponseEntity
		        .status(HttpStatus.NOT_FOUND)
		        .body(exception.getMessage());
	}
}
