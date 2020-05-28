package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here

        Calculator calculator = new Calculator();

        calculator.set_number_values("IV","II");
        calculator.set_symbol("*");
        calculator.calculate();
        calculator.output_result();


        calculator.set_number_values("6","9");
        calculator.set_symbol("+");
        calculator.calculate();
        calculator.output_result();

        calculator.input_fromTerminal();

    }
}
