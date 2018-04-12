package com.templatejsf.exception;

public class BDException extends Exception {

    public BDException() {
    }

    public BDException(String message) {
        super(message);
    }

    public BDException(String message, Throwable cause) {
        super(message, cause);
    }

    public BDException(Throwable cause) {
        super(cause);
    }
}
