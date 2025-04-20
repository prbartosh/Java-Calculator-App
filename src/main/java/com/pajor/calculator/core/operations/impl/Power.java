package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;
import com.pajor.calculator.exception.DivisionByZeroException;

public class Power implements Operation {
    @Override
    public double apply(double a, double b) {
        if (a == 0 && b == 0) {
            throw new java.lang.ArithmeticException("Undefined Symbol! Can't resolve");
        } else if (a == 0 && b < 0) {
            throw new DivisionByZeroException("Division by Zero is not allowed!");
        } else {
            return Math.pow(a, b);
        }
    }
}