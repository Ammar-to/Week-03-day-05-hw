package com.example.demodd.AdviceExceptionHandeling;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity dataIntegrityViolationException(DataIntegrityViolationException e){
        return ResponseEntity.status(400).body(e.getRootCause().getMessage());
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity invalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e){
        return ResponseEntity.status(400).body(e.getRootCause().getMessage());
    }
}
