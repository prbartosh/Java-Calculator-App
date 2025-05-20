package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Factorial implements Operation{
    @Override
    public int arity() { return 1; }

    @Override
    public double apply(double... args) {
        double result = 1;
        double i = args[0];
        do {
            result *= i;
            i--;
        } while (i > 0);

        return result;
    }
    
}
