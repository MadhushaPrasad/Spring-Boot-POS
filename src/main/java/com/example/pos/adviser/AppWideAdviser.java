package com.example.pos.adviser;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideAdviser {

    @ExceptionHandler(Exception.class)
    public String handleMyException(Exception ex) {
        return ex.getMessage();
    }
}
