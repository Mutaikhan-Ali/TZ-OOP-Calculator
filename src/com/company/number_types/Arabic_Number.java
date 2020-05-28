package com.company.number_types;
import com.company.Operations.*;
import com.company.exceptions.Operation_Exception;
import com.company.exceptions.Range_Exception;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Arabic_Number implements Number_Type
{
    private String result;
    private int number_1;
    private int number_2;
    private Operation operation;


    public Arabic_Number(){}

    public int getNumber_1()
    {
        return number_1;
    }

    public void setNumber_1(int number_1) {
        this.number_1 = number_1;
    }

    public int getNumber_2() {
        return number_2;
    }

    public void setNumber_2(int number_2) {
        this.number_2 = number_2;
    }

    public Operation getOperation()
    {
        return operation;
    }

    public void setOperation(Operation operation)
    {
        this.operation = operation;
    }

    public String getResult()
    {
        return result;
    }

    private void setResult(String result) {
        this.result = result;
    }

    public void check_exceptions(String n1, String n2, String sym) throws Exception
    {
        if (Integer.parseInt(n1) > 10 || Integer.parseInt(n2) > 10 || Integer.parseInt(n1) < 1 || Integer.parseInt(n2) < 1)
        {
                throw new Range_Exception("Can't be upper than 10 and Can't be lower than 1 ");
        }

        if(!sym.equals("+") &&  !sym.equals("-") && !sym.equals("/") &&  !sym.equals("*"))
        {
            throw new Operation_Exception("ONLY 4 MATH OPERATIONS (+,*,/,-)");
        }
    }
    public void check_exceptions(String n1, String n2) throws Exception
    {
        if (Integer.parseInt(n1) > 10 || Integer.parseInt(n2) > 10 || Integer.parseInt(n1) < 1 || Integer.parseInt(n2) < 1)
        {
                throw new Range_Exception("Can't be upper than 10 and Can't be lower than 1 ");
        }
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

    public Arabic_Number(String n1, String n2, String sym) throws Exception
    {
        check_exceptions(n1, n2, sym);
        number_1 = Integer.parseInt(n1);
        number_2 = Integer.parseInt(n2);
        setOperation(determine_Operation(sym));
    }

    public Arabic_Number(String n1, String n2) throws Exception
    {
        check_exceptions(n1, n2);
        number_1 = Integer.parseInt(n1);
        number_2 = Integer.parseInt(n2);
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
       result = Integer.toString(operation.do_operation(number_1, number_2));
    }

    public String do_calculation_return()
    {
        do_calculation();
        return result;
    }

    public void set_values(String n1, String n2, String sym) throws Exception
    {
        check_exceptions(n1, n2, sym);
        number_1 = Integer.parseInt(n1);
        number_2 = Integer.parseInt(n2);
        setOperation(determine_Operation(sym));
    }

    public void set_values(String n1, String n2) throws Exception
    {
        check_exceptions(n1, n2);
        number_1 = Integer.parseInt(n1);
        number_2 = Integer.parseInt(n2);
    }


}
