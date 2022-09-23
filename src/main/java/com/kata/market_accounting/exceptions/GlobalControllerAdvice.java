package com.kata.market_accounting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>(noSuchElementException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleEmptyInputException(EmptyInputException emptyInputException) {
        return new ResponseEntity<>(emptyInputException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
