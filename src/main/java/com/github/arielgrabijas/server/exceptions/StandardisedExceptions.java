package com.github.arielgrabijas.server.exceptions;

import org.springframework.http.HttpStatus;

public enum StandardisedExceptions {

    STALE_DATA_EXCEPTION("Próba modyfikacji danych ze starym numerem wersji.", HttpStatus.INTERNAL_SERVER_ERROR,
            "Dane zostały w międzyczasie zmodyfikowane. Należy odświeżyć zasób i ponownie go zmodyfikować.");

    private final String messagePattern;
    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String details;

    StandardisedExceptions(String messagePattern, HttpStatus httpStatus, String details) {
        this.messagePattern = messagePattern;
        this.httpStatus = httpStatus;
        this.errorCode = this.name();
        this.details = details;
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

    public String getDetails() {
        return details;
    }
}
