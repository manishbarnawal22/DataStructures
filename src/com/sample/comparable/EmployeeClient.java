package com.sample.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeClient
{
    public static void main( String[] args )
    {
        Employee lEmployee1 = new Employee(1,"Manish");
        Employee lEmployee2 = new Employee(2,"B");
        Employee lEmployee3 = new Employee(4,"Suman");
        Employee lEmployee4 = new Employee(3,"Shashi");
        
        List<Employee> lEmployees = new ArrayList<>();
        lEmployees.add( lEmployee1 );
        lEmployees.add( lEmployee2 );
        lEmployees.add( lEmployee3 );
        lEmployees.add( lEmployee4 );
        
        Collections.sort( lEmployees );
        System.out.println( lEmployees.toString() );
    }
}
