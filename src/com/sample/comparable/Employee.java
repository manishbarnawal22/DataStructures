package com.sample.comparable;

class Employee implements Comparable<Employee>{
    
    int id;
    String name;
    public String getName()
    {
        return name;
    }
    public void setName( String name )
    {
        this.name = name;
    }
    public int getId()
    {
        return id;
    }
    public void setId( int id )
    {
        this.id = id;
    }
    Employee(int id, String name)
    {
        this.id=id;
        this.name = name;
    }
    
    public String toString()
    {
        return "["+id+"," +name+"]"; 
    }
    @Override
    public int compareTo( Employee o )
    {
        return -(id-o.getId());
    }
    
}