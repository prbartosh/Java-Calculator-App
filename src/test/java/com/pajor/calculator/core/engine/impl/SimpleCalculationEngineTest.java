package com.pajor.calculator.core.engine.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.pajor.calculator.core.operations.impl.*;
import com.pajor.calculator.exception.DivisionByZeroException;

public class SimpleCalculationEngineTest {
    private final SimpleCalculationEngine engine = new SimpleCalculationEngine();
    private final Addition addition = new Addition();
    private final Subtraction subtract = new Subtraction();
    private final Division divide = new Division();

    @Test
    void addition() {
        double a = 2;
        double b = 3;
        double excepted = 5;

        double result = engine.calculate(addition, a, b);
        Assertions.assertEquals(excepted, result, 0.000001);
    }

    @Test
    void subtraction() {
        Assertions.assertEquals(4,engine.calculate(subtract, 10, 6));
    }

    @Test
    void division() {
        double a = 10;
        double b = 0;
        DivisionByZeroException exception = Assertions.assertThrows(DivisionByZeroException.class, () -> engine.calculate(divide, a, b));
        Assertions.assertEquals("Division by Zero is not allowed!", exception.getMessage());
    }

}
