package com.sample.test1;

public class MainClass
{
	public static void main(String[] args) {
		ChildClass lClass = new ChildClass();
		lClass.testSuper();
	}
}

class ChildClass extends SuperClass
{
    void testSuper()
    {
        super.test();
    }
    
    @Override
    public void test()
    {
        System.out.println( "Inside Child test." );
    }

}
