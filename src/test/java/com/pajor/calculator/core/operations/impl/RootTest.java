package com.pajor.calculator.core.operations.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RootTest {
    private final Root root = new Root();
    private final double delta = 0.000001;

    @Test
    void testSquareRoot() {
        double a = 9;
        double b = 2;
        double expected = 3;

        double actual = root.apply(a, b);
        Assertions.assertEquals(expected, actual, delta);
    }

    @Test
    void testCubeRoot() {
        Assertions.assertEquals(3.0, root.apply(27.0, 3.0), delta);
    }

    @Test
    void testRootOfOne() {
        Assertions.assertEquals(1.0, root.apply(1.0, 1000.0), delta);
    }

    @Test
    void testRootOfZero() {
        Assertions.assertEquals(0.0, root.apply(0.0, 5.0), delta);
    }

    @Test
    void testOddRootOfNegative() {
        Assertions.assertEquals(-2.0, root.apply(-8.0, 3.0), delta);
    }

    @Test
    void testEvenRootOfNegative() {
        Assertions.assertTrue(Double.isNaN(root.apply(-16.0, 2.0)));
    }

    @Test
    void testZeroAsRootDegree() {
        Assertions.assertEquals(1.0, root.apply(10.0, 0.0), delta);
    }

    @Test
    void testNaNInput() {
        Assertions.assertTrue(Double.isNaN(root.apply(Double.NaN, 2.0)));
    }

    @Test
    void testInfinityInput() {
        Assertions.assertEquals(Double.POSITIVE_INFINITY, root.apply(Double.POSITIVE_INFINITY, 2.0));
    }

    @Test
    void testNegativeInfinityInput() {
        Assertions.assertTrue(Double.isInfinite(root.apply(Double.NEGATIVE_INFINITY, 2.0)));
    }

    @Test
    void testFractionalRootDegree() {
        Assertions.assertEquals(256.0, root.apply(16.0, 0.5), delta); // 16^(1/0.5) = 16^2
    }
}
