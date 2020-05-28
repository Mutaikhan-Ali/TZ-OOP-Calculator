package com.company;

import com.company.exceptions.InvalidNumberException;
import com.company.exceptions.Roman_NumberException;
import com.company.number_types.Arabic_Number;
import com.company.number_types.Number_Type;
import com.company.number_types.Roman_Number;

import java.util.Scanner;

public class Calculator  // отвечает за сборку компонентов
{
    // поля
    private Number_Type number_type; // arabic or rim
    private int numberType;
    private String result;
    private String symbol;
    private boolean set_symbol = true;
    // геттеры и сеттеры
    public Number_Type getNumber_type()
    {
        return number_type;
    }

    public void setNumber_type(Number_Type number_type) {
        this.number_type = number_type;
    }

    public int getNumberType() {
        return numberType;
    }

    public void setNumberType(int numberType) {
        this.numberType = numberType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    // методы
    private Number_Type determine_numberType(String number_1, String number_2) throws Exception
    {
        int type;  // 0 - arabic   1 - rim
        type = check_numberType(number_1, number_2);

        switch (type)
        {
            case 0 : return new Arabic_Number();
            case 1 : return new Roman_Number();
        }
        return null;
    }
    public boolean check_for_Roman(String number,String number2)
    {
        if(is_RomanNumber(number) && is_RomanNumber(number2))
        {
            return true;
        }
        return false;
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

    public int check_numberType(String number_1, String number_2) throws Exception
    {
        if(number_1 == null || number_2 == null)
        {
            throw new InvalidNumberException("Input values are null");
        }

        if(check_for_Arabic(number_1, number_2))
        {
            return 0;
        }

        else if(check_for_Roman(number_1,number_2))
        {
            return 1;
        }
        else if(!check_for_Roman(number_1,number_2))
        {
            throw  new Roman_NumberException("Inputs are invalid");
        }

        return -1;
    }

    public boolean check_for_Arabic(String number_1, String number_2)
    {
            try
            {
                int number = Integer.parseInt(number_1);
                int number2 = Integer.parseInt(number_2);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            return true;
    }

    /*public boolean check_for_Rim(String number_1, String number_2)
    {
        try
        {
          Rim_Number.parseRim(number_1);
          Rim_Number.parseRim(number_2);
        }

        catch (Rim_NumberException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }
*/
    public void set_number_values(String number_1, String number_2,String symbol) throws Exception
    {
            setNumber_type(determine_numberType(number_1, number_2));
            number_type.check_exceptions(number_1,number_2, symbol);
            number_type.set_values(number_1,number_2,symbol);
            set_symbol = false;
    }

    public void calculate()
    {
        if(set_symbol)
        {
            number_type.set_Symbol(symbol);
        }

        number_type.do_calculation();
    }

    public void calculate(String number_1, String number_2) throws Exception
    {
        number_type.set_values(number_1,number_2);
        number_type.do_calculation();
    }
    public void calculate(String number_1, String number_2,String symbol) throws Exception
    {
        number_type.set_values(number_1,number_2,symbol);
        number_type.do_calculation();
    }

    public void set_number_values(String number_1, String number_2) throws Exception
    {
        setNumber_type(determine_numberType(number_1, number_2));
        number_type.check_exceptions(number_1,number_2);
        number_type.set_values(number_1,number_2);
    }

    public void set_symbol(String symbol)
    {
        this.symbol = symbol;
    }
    public String get_symbol(String symbol){ return symbol;}

    public void output_result()
    {
        setResult(number_type.get_Result());
        if(getResult() != null)
        {
            System.out.println(getResult());
        }
    }

    public void input_fromTerminal() throws Exception {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[]array = data.split(" ");
        String number_1 = array[0];
        String number_2 = array[2];
        String symbol = array[1];

        setNumber_type(determine_numberType(number_1,number_2));
        number_type.set_values(number_1,number_2,symbol);
        number_type.do_calculation();
        output_result();


    }


}
