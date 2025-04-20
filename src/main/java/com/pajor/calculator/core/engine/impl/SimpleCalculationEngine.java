package com.pajor.calculator.core.engine.impl;

import com.pajor.calculator.core.engine.api.CalculationEngine;
import com.pajor.calculator.core.operations.api.Operation;

public class SimpleCalculationEngine implements CalculationEngine {
    @Override
    public double calculate(Operation operation, double a, double b){
        return operation.apply(a, b);
    }
}
