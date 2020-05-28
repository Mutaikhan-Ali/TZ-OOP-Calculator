package com.company.Operations;

public class NullValue implements Operation
{
    public int do_operation(int number_1, int number_2)
    {
        System.err.println("Operation value doesn't assigned. Exit:");
        return -1;
    }
}
