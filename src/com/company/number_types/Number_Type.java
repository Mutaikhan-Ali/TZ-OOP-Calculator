package com.company.number_types;

import com.company.Operations.Operation;

public interface Number_Type
{
   public String get_Result();
   public void do_calculation();
   public String do_calculation_return();
   public void set_values(String n1, String n2, String sym) throws Exception;
   public void set_values(String n1, String n2) throws Exception;
   public Operation determine_Operation(String sym);
   public void set_Symbol(String symbol);
   public void check_exceptions(String n1, String n2, String sym) throws Exception;
   public void check_exceptions(String n1, String n2) throws Exception;

}
