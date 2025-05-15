package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Percetage implements Operation {
    @Override
    public double apply(double a, double b) {
        return a * (b / 100.0);
    }
}
