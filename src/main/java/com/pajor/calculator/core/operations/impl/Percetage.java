package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Percetage implements Operation {
    @Override
    public int arity() { return 2; }

    @Override
    public double apply(double... args) {
        return args[0] * (args[1] / 100.0);
    }
}
