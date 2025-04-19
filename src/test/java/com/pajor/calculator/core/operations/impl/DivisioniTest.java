package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    
    
}
