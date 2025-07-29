package com.example.pos.adviser;

import com.example.pos.handler.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdviser {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleMyException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(AppException.class)
    public String handleMyException(AppException ex) {
        return ex.getMessage();
    }
}
