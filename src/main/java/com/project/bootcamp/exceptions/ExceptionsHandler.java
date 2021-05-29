package com.project.bootcamp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(businessException.class)
    protected ResponseEntity<exceptionResponse> handleSecurity(businessException e){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new exceptionResponse(e.getMessage()));
    }

    @ExceptionHandler(notFoundException.class)
    protected ResponseEntity<exceptionResponse> handleSecurity(notFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new exceptionResponse(e.getMessage()));
    }

}
