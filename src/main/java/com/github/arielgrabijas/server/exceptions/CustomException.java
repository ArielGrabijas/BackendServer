package com.github.arielgrabijas.server.exceptions;

public class CustomException extends Exception {

    private static final long serialVersionUID = 5779162691676904946L;

    public CustomException(StandardisedExceptions exception) {
        super(exception.getMessagePattern());
    }
}
