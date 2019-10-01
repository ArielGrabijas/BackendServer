package com.github.arielgrabijas.server.exceptions;

import org.springframework.http.HttpStatus;

public enum StandardisedExceptions {

    STALE_DATA_EXCEPTION("Próba modyfikacji danych ze starym numerem wersji.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String messagePattern;
    private final HttpStatus httpStatus;
    private final String errorCode;

    StandardisedExceptions(String messagePattern, HttpStatus httpStatus) {
        this.messagePattern = messagePattern;
        this.httpStatus = httpStatus;
        this.errorCode = this.name();
    }

    public String getMessagePattern() {
        return messagePattern;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
