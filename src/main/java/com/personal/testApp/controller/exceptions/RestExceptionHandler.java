package com.personal.testApp.controller.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException ex) {
    var errorMessage = ex.getConstraintViolations().iterator().next().getMessage();
    var errorResponse = ErrorMessage.builder()
        .message("Invalid request")
        .description(errorMessage)
        .build();

    return ResponseEntity.badRequest().body(errorResponse);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorMessage> handleIllegalArgumentException(MissingServletRequestParameterException ex) {
    var errorResponse = ErrorMessage.builder()
        .message("Invalid request")
        .description(ex.getMessage())
        .build();

    return ResponseEntity.badRequest().body(errorResponse);
  }
}
