package com.company.Operations;

public class Unknown_Operation implements Operation
{
    public int do_operation(int number_1, int number_2)
    {
        System.err.println("We don't know this operation. Exit:");
        return -1;
    }
}
