package com.pajor.calculator.core.operations.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubtractionTest {

    private Subtraction subtraction;

    @BeforeEach
    void setUp() {
        subtraction = new Subtraction();
    }

    @Test
    void testSubtractionOfPositiveNumbers() {
        assertEquals(5.0, subtraction.apply(10.0, 5.0), 0.0001);
    }

    @Test
    void testSubtractionWithNegativeResult() {
        assertEquals(-2.0, subtraction.apply(3.0, 5.0), 0.0001);
    }

    @Test
    void testSubtractionWithZero() {
        assertEquals(7.0, subtraction.apply(7.0, 0.0), 0.0001);
    }

    @Test
    void testSubtractionToZero() {
        assertEquals(0.0, subtraction.apply(4.0, 4.0), 0.0001);
    }

    @Test
    void testSubtractionOfNegativeNumbers() {
        assertEquals(-5.0, subtraction.apply(-2.0, 3.0), 0.0001);
    }

    @Test
    void testSubtractionWithDecimals() {
        assertEquals(2.25, subtraction.apply(5.5, 3.25), 0.0001);
    }

    @Test
    void testSubtractionWithLargeNumbers() {
        assertEquals(1e10, subtraction.apply(2e10, 1e10), 1e5);
    }
}
