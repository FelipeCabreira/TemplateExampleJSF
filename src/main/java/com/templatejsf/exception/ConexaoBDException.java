package com.templatejsf.exception;


public class ConexaoBDException extends Exception {

    public ConexaoBDException() {
    }

    public ConexaoBDException(String message) {
        super(message);
    }

    public ConexaoBDException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConexaoBDException(Throwable cause) {
        super(cause);
    }
}
