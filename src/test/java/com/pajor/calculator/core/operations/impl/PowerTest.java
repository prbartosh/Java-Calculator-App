package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.pajor.calculator.exception.DivisionByZeroException;

public class PowerTest {
    private final Power power = new Power();
    private final double delta = 0.000001;

    @Test
    void PositiveOverPositive() {
        double a = 2;
        double b = 3;
        double expected = 8;

        double actual = power.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }
    
    @Test
    void PositiveOverZero() {
        double a = 2;   
        double b = 0;
        double expected = 1;

        double actual = power.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }
    
    @Test
    void ZeroOverPositive() {
        double a = 0;
        double b = 3;
        double expected = 0;

        double actual = power.apply(a, b);  
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void ZeroOverZero() {
        double a = 0;
        double b = 0;
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> power.apply(a, b));
        Assertions.assertEquals("Undefined Symbol! Can't resolve", exception.getMessage());
    }

    @Test
    void NegativeOverPositiveOdd() {
        double a = -2;
        double b = 3;
        double expected = -8;

        double actual = power.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void NegativeOverPositiveEven() {
        double a = -2;
        double b = 2;
        double expected = 4;

        double actual = power.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }
    
    @Test
    void FloatOverFloat() {
        double a = 2.5;
        double b = 2.5;
        double expected = 9.882117;

        double actual = power.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void PositiveOverNegative() {
        double a = 2;
        double b = -3;
        double expected = 0.125;

        double actual = power.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void ZeroOverNegative() {
        double a = 0;
        double b = -3;

        DivisionByZeroException exception = Assertions.assertThrows(DivisionByZeroException.class, () -> power.apply(a, b));
        Assertions.assertEquals("Division by Zero is not allowed!", exception.getMessage());
    }
        
    
}   
