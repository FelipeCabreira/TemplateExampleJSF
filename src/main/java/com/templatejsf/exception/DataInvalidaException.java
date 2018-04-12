package com.templatejsf.exception;

public class DataInvalidaException extends Exception {

    public DataInvalidaException() {
    }

    public DataInvalidaException(String message) {
        super(message);
    }

    public DataInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataInvalidaException(Throwable cause) {
        super(cause);
    }
}
