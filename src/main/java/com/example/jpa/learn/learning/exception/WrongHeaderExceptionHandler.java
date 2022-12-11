package com.example.jpa.learn.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@ControllerAdvice
public class WrongHeaderExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {WrongHeaderException.class})
    public ResponseEntity<WrongHeaderResponse> handleException(WrongHeaderException ex){
        return new ResponseEntity<>(new WrongHeaderResponse(LocalDateTime.now(),ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
