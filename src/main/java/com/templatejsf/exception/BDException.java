package com.templatejsf.exception;

/**
 * Created by allanmoreira on 30/12/16.
 */
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
