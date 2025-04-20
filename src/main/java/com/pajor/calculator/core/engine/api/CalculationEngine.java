package com.pajor.calculator.core.engine.api;

import com.pajor.calculator.core.operations.api.Operation;

public interface CalculationEngine {
    double calculate(Operation operation, double a, double b);
}