package com.company.exceptions;

public class Range_Exception extends Exception
{
    public Range_Exception() {
    }

    public Range_Exception(String message) {
        System.err.println(message);
    }

    public Range_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Range_Exception(Throwable cause) {
        super(cause);
    }

    public Range_Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
