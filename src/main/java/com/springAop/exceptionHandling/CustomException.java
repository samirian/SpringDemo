package com.springAop.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
/*
 * Allows us to modify the HTTP status of the response and can be applied to :
 * 1- the exception class itself.
 * 2- along with the @ExceptionHandler on the methods.
 * 3- along with the @ontrollerAdvice on classes.
 */
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;

}
