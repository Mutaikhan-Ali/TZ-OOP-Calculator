package com.company.exceptions;

public class Operation_Exception extends Exception
{
    public Operation_Exception() {
    }

    public Operation_Exception(String message) {
        super(message);
    }

    public Operation_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Operation_Exception(Throwable cause) {
        super(cause);
    }

    public Operation_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
