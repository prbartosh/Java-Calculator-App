package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;
import com.pajor.calculator.exception.DivisionByZeroException;

public class Division implements Operation {
    @Override
    public double apply(double a, double b) {
        if (b == 0){
            throw new DivisionByZeroException("Division by Zero is not allowed!");
        } else{
            return a / b;
        }
    }
}

