package com.workforce.springbootshiftbelonger.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, RuntimeException.class,
	    Exception.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
	String bodyOfResponse = "Something went wrong at server.";
	return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
		request);
    }

    @ExceptionHandler(value = AppManagerServiceException.class)
    public ResponseEntity<String> handlerForAppManagerServiceException(AppManagerServiceException exception) {
	if (exception.getStatusCode() == 0) {
	    exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
	}
	return createVndErrorsResponseEntity(new AppManagerServiceException(exception.getMessage()),
		HttpStatus.valueOf(exception.getStatusCode()));
    }

    private static ResponseEntity<String> createVndErrorsResponseEntity(AppManagerServiceException exception,
	    HttpStatus statusCode) {

	final HttpHeaders header = new HttpHeaders();
	header.setContentType(MediaType.parseMediaType("application/vnd.error+json"));

	return new ResponseEntity<>(exception.getMessage(), header, statusCode);
    }

}