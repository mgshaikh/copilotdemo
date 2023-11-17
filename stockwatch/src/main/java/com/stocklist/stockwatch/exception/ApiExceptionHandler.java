package com.stocklist.stockwatch.exception;

// Gloabal Exception handler for StockNotFoundException and StockAlreadyExistsException

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleStockNotFoundException(StockNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }   

    @ExceptionHandler(StockAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleStockAlreadyExistsException(StockAlreadyExistsException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    // Add a generic exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
