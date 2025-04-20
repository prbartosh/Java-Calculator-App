package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.pajor.calculator.exception.DivisionByZeroException;

public class DivisioniTest {
    private final Division division = new Division();
    private final double delta = 0.000001;

    @Test
    void TwoPositive() {
        double a = 10;
        double b = 2;
        double expected = 5;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void PositiveOverNegative() {
        double a = 10;
        double b = -2;
        double expected = -5;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void NegativeOverPositive() {
        double a = -10;
        double b = 2;
        double expected = -5;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }
    
    @Test
    void NegativeOverNegative() {
        double a = -10;
        double b = -2;
        double expected = 5;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void DivideOverOne() {
        double a = 10;
        double b = 1;
        double expected = 10;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void DivierOverItself() {
        double a = 10;
        double b = 10;
        double expected = 1;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void DivideFloat() {    
        double a = 10.5;
        double b = 2.5;
        double expected = 4.2;

        double actual = division.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void DivideByZero() {
        double a = 10;
        double b = 0;
        DivisionByZeroException exception = Assertions.assertThrows(DivisionByZeroException.class, () -> division.apply(a, b));
        Assertions.assertEquals("Division by Zero is not allowed!", exception.getMessage());
    }

    @Test
    void DivideByZeroFloat() {
        double a = 10.5;
        double b = 0;
        DivisionByZeroException exception = Assertions.assertThrows(DivisionByZeroException.class, () -> division.apply(a, b));
        Assertions.assertEquals("Division by Zero is not allowed!", exception.getMessage());
    }

    @Test
    void DivideBeFloatZero() {
        double a = 10.5;
        double b = 0.0;
        DivisionByZeroException exception = Assertions.assertThrows(DivisionByZeroException.class, () -> division.apply(a, b));
        Assertions.assertEquals("Division by Zero is not allowed!", exception.getMessage());
    }
    
    
}
