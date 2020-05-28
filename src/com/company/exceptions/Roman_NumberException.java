package com.company.exceptions;

public class Roman_NumberException extends Exception
{
    public Roman_NumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public Roman_NumberException(Throwable cause) {
        super(cause);
    }

    public Roman_NumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Roman_NumberException(String s) {
    }

    public static boolean has_trueSymbols(String number)
    {
        String  []symbols = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        for(String symbol : symbols)
        {
            if(!number.contains(symbol))
            {
                return false;
            }
        }
        return true;
    }

}
