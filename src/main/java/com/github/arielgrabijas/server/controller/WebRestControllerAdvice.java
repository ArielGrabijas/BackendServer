package com.github.arielgrabijas.server.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.arielgrabijas.server.exceptions.CustomException;
import com.github.arielgrabijas.server.exceptions.StandardisedExceptions;

@RestControllerAdvice
public class WebRestControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public StandardisedExceptions handleCustomException(CustomException exception) {
        return StandardisedExceptions.STALE_DATA_EXCEPTION;
    }
}
