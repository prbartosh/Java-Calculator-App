package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SqrtTest {
    private final Sqrt sqrt = new Sqrt();
    private final double delta = 0.000001;

    @Test
    void PositiveInteger() {
        double a = 9;
        double expected = 3;

        double actual = sqrt.apply(a, a);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void SqrtOfZero() {
        double a = 0;
        double expected = 0;

        double actual = sqrt.apply(a, a);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void SqrtofFloat() {
        double a = 2.25;
        double expected = 1.5;

        double actual = sqrt.apply(a, a);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void SqrtOfNegative() {
        double a = -4;
        Assertions.assertTrue(Double.isNaN(sqrt.apply(a, a)));
    }
}
