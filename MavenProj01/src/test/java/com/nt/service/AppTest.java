package com.nt.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void testWithPositives()
    {
    	 int  a=10;
    	 int b=20;
    	 int expected=30;
    	   App app1=new App();
    	 int  actual=app1.sum(a, b);
        assertEquals(expected,actual);
    }
    @Test
    public void testWithNegetives()
    {
    	 int  a=-10;
    	 int b=-20;
    	 int expected=-30;
    	   App app1=new App();
    	 int  actual=app1.sum(a, b);
        assertEquals(expected,actual);
    }
    
    
    @Test
    public void testWithMixedValues()
    {
    	 int  a=10;
    	 int b=-20;
    	 int expected=-10;
    	   App app1=new App();
    	 int  actual=app1.sum(a, b);
        assertEquals(expected,actual);
    }
}
