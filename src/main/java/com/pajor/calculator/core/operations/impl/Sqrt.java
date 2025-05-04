package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Sqrt implements Operation {
    @Override
    public double apply(double a, double b) {
            if (b==a) {
                return Math.sqrt(a);
            } else {
                throw new UnsupportedOperationException("Sqrt operation only supports one operand");
            }
    }
}