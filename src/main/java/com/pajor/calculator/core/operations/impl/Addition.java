package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Addition implements Operation {
    @Override
    public double apply(double a, double b) {
        return a + b;
    }
}
