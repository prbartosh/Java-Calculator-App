package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Root implements Operation{
    @Override
    public int arity() { return 2; }
    
    @Override
    public double apply(double... args) {
        double a = args[0];
        double b = args[1];

        if (a < 0 && b % 2 != 0) {
            return -Math.pow(-a, 1.0/b);
        } else if (b == 0) {
            return 1.0;
        } else {
            return Math.pow(a, 1.0/b);
        }
    }
}
