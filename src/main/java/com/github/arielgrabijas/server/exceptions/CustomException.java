package com.github.arielgrabijas.server.exceptions;

public class CustomException extends Exception {

    public CustomException(StandardisedExceptions exception) {
        super(exception.getMessagePattern());
    }
}
