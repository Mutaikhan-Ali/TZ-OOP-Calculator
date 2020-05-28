package com.company.number_types;

import com.company.Operations.*;
import com.company.exceptions.Operation_Exception;
import com.company.exceptions.Range_Exception;

public class Roman_Number implements Number_Type
{

    private String result;
    private int number_1;
    private int number_2;
    private Operation operation;

    public Roman_Number(){}

    public static int parseRoman(String num)
    {
            switch(num)
            {
                case "I" : return 1;
                case "II" : return 2;
                case "III" : return 3;
                case "IV" : return 4;
                case "V" : return 5;
                case "VI" : return 6;
                case "VII" : return 7;
                case "VIII" : return 8;
                case "IX" : return 9;
                case "X" : return 10;
            }
            return -1;
    }

    public static String parseToRoman(int n)
    {
        int[] values = {100,90,50,40,10,9,5,4,1};
        String[] symbols = {"C","XC","L","XL","X","IX","V","IV","I"};

        StringBuffer roman = new StringBuffer();

        for(int i=0;i<values.length;i++)
        {
            while(n >= values[i])
            {
                n = n - values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    public void setOperation(Operation operation)
    {
        this.operation = operation;
    }
    public Operation getOperation()
    {
        return operation;
    }
    public String getResult()
    {
        return result;
    }
    private void setResult(String result) {
        this.result = result;
    }
    public void set_Symbol(String symbol)
    {
        setOperation(determine_Operation(symbol));
    }
    public Operation determine_Operation(String sym)
    {
        if(sym == null)
        {
            return new NullValue();
        }
        switch (sym)
        {
            case "+" : return new Add();
            case "-" : return new Substract();
            case "*" : return new Multiplication();
            case "/" : return new Division();
        }
        return new Unknown_Operation();
    }
    public String get_Result()
    {
        return result;
    }
    public void do_calculation()
    {
        if(operation == null)
        {
            System.err.println("oops, smth went wrong with operation value");
            return;
        }
        result = Roman_Number.parseToRoman(operation.do_operation(number_1, number_2));
    }
    public String do_calculation_return()
    {
        do_calculation();
        return result;
    }

    public boolean is_RomanNumber(String number)
    {
        String []symbols = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        for(String s : symbols)
        {
            if(number.equals(s))
            {
                return true;
            }
        }
        return false;
    }

    public void check_exceptions(String n1, String n2, String sym) throws Exception
    {
        if (!is_RomanNumber(n1) || !is_RomanNumber(n2))
        {
            throw new Range_Exception("Roman number is invalid. Should be from 0 to 10");
        }

        if(!sym.equals("+") &&  !sym.equals("-") && !sym.equals("/") &&  !sym.equals("*"))
        {
            throw new Operation_Exception("ONLY 4 MATH OPERATIONS (+,*,/,-)");
        }
    }
    public void check_exceptions(String n1, String n2) throws Exception
    {
        if (!is_RomanNumber(n1) || !is_RomanNumber(n2))
        {
            throw new Range_Exception("Roman number is invalid. Should be from 0 to 10");
        }
    }

    public void set_values(String n1, String n2, String sym) throws Exception
    {
        check_exceptions(n1, n2, sym);
        number_1 = Roman_Number.parseRoman(n1);
        number_2 = Roman_Number.parseRoman(n2);
        setOperation(determine_Operation(sym));
    }

    public void set_values(String n1, String n2) throws Exception
    {
        check_exceptions(n1, n2);
        number_1 = Roman_Number.parseRoman(n1);
        number_2 = Roman_Number.parseRoman(n2);
    }

}
