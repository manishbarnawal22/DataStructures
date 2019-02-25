package com.sample.comparator;

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
        
        Collections.sort( lEmployees, new EmployeeAttrComparator().IdComparator );
        System.out.println( "Sort By Id:"+lEmployees.toString() );
        
        Collections.sort( lEmployees, new EmployeeAttrComparator().NameComparator );
        System.out.println( "Sort by name:"+lEmployees.toString() );
    }
    
    
}
