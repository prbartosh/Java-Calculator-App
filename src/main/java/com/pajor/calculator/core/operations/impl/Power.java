package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;
import com.pajor.calculator.exception.DivisionByZeroException;

public class Power implements Operation {
    @Override
    public int arity() { return 2; }
    
    @Override
    public double apply(double... args) {
        if (args[0] == 0 && args[1] == 0) {
            throw new java.lang.ArithmeticException("Undefined Symbol! Can't resolve");
        } else if (args[0] == 0 && args[1] < 0) {
            throw new DivisionByZeroException("Division by Zero is not allowed!");
        } else {
            return Math.pow(args[0], args[1]);
        }
    }
}