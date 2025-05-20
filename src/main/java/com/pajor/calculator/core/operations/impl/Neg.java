package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Neg implements Operation{
    @Override
    public int arity() { return 1; }
    @Override
    public double apply(double... args) {
        return -args[0];
    }
}
