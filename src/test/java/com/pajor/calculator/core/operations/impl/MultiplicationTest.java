package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {
    private final Multiplication multiplication = new Multiplication();

    @Test
    void shouldMultiplyTwoPositiveNumbers() {
        double a = 1.234;
        double b = 2.345;
        double expected = 2.89373;

        double result = multiplication.apply(a, b);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    @Test
    void shouldMultiplyTwoNegativeNumbers() {
        double a = -1;
        double b = -3;
        double expected = 3;

        double result = multiplication.apply(a, b);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    @Test
    void shouldMultiplyPositiveAndNegativeNumbers() {
        double a = 1;
        double b = -3;
        double expected = -3;

        double result = multiplication.apply(a, b);
        Assertions.assertEquals(expected, result, 0.00001);
    }

    @Test
    void shouldMultiplyNumberAndZero() {
        double a = 1;
        double b = 0;
        double expected = 0;

        double result = multiplication.apply(a, b);
        Assertions.assertEquals(expected, result, 0.00001);
    }
}