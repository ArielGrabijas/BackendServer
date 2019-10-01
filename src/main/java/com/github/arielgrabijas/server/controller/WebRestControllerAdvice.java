package com.github.arielgrabijas.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.arielgrabijas.server.exceptions.StandardisedExceptions;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(org.hibernate.StaleObjectStateException.class)
    public ResponseEntity<String> handleStaleStateException(org.hibernate.StaleObjectStateException e) {

        return new ResponseEntity<>(StandardisedExceptions.STALE_DATA_EXCEPTION.getMessagePattern(),
                StandardisedExceptions.STALE_DATA_EXCEPTION.getHttpStatus());
    }

}
