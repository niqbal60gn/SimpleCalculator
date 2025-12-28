package com.example.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.Calculator;

public class CalculatorTest {
    
    private Calculator calculator = new Calculator();
    
    @Test
    public void testAdd() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }
    
    @Test
    public void testSubtract() {
        Assert.assertEquals(calculator.subtract(5, 3), 2);
    }
    
    @Test
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(2, 3), 6);
    }
    
    @Test
    public void testDivide() {
        Assert.assertEquals(calculator.divide(6, 3), 2.0);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }
}