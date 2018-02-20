package com.templatejsf.exception;

/**
 * Created by allanmoreira on 30/12/16.
 */
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
