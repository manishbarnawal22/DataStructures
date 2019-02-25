package com.sample.comparator;

import java.util.Comparator;

public class EmployeeAttrComparator
{
    Comparator<Employee> IdComparator  = (o1,o2)->o1.getId()-o2.getId();
    
    Comparator<Employee> NameComparator  = new Comparator<Employee>()
    {
        @Override
        public int compare( Employee o1,
                            Employee o2 )
        {
            return (o1.getName()).compareTo( o2.getName());
        }
        
    };
}
