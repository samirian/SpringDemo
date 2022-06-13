package com.springAop.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
/*
 * allows us to intercept and modify the return values of the controller methods and not limited
 * to handling exceptions.
 * can be applied on one or more controllers.
 * @ControllerAdvice
 * @ControllerAdvice("com.reflectoring.controller")
 * @ControllerAdvice({"com.reflectoring.controller", ..})
 * @ControllerAdvice(annotations = Advised.class): only controllers marked with the @Advised
 * annotation will be handled by the controller advice.
 */
public class GlobalExceptionHandler {
	@ExceptionHandler({CustomException.class})
	/*
	 * indicates the exception classes that will be handled by the annotated method.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	/*
	 * sets the status code of the response after handling the exception.
	 * can be applied to a method or the exception class itself.
	 */
	public ResponseEntity<Object> handleConflict(
		      RuntimeException ex, WebRequest request) {
		return  new ResponseEntity<Object>(
		          "Access denied message here", new org.springframework.http.HttpHeaders(), HttpStatus.FORBIDDEN);
	}
}
