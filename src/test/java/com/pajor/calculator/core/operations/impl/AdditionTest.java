package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.pajor.calculator.core.operations.impl.Addition;

public class AdditionTest {

    private final Addition addition = new Addition();

    @Test
    void shouldAddTwoPositiveNumbers() {
        double a = 2.0;
        double b = 5.0;
        double expected = 7.0;

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }

    @Test
    void shouldAddPositiveAndNegativeNumbers() {
        double a = 2.0;
        double b = -5.0;
        double expected = -3.0;

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }

    @Test
    void shouldAddNegativeAndPositiveNumbers() {
        double a = -2.0;
        double b = 5.0;
        double expected = 3.0;

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }

    @Test   
    void shouldAddTwoNegativeNumbers() {
        double a = -2.0;
        double b = -5.0;
        double expected = -7.0;

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }

    @Test
    void shouldAddZeroToPositiveNumber() {
        double a = 2.0;
        double b = 0.0;
        double expected = 2.0;

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }

    @Test
    void shouldAddZeroToNegativeNumber() {
        double a = -2.0;
        double b = 0.0;
        double expected = -2.0;     

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }

    @Test
    void shouldAddZeroToZero() {
        double a = 0.0;
        double b = 0.0;
        double expected = 0.0;  

        double result = addition.apply(a, b);
        Assertions.assertEquals(expected, result, 0.0001);
    }
    
}
