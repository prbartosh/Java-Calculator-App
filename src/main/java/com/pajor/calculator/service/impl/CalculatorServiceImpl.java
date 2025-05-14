package com.pajor.calculator.service.impl;

import com.pajor.calculator.service.api.CalculatorService;
import com.pajor.calculator.core.engine.impl.SimpleCalculationEngine;
import com.pajor.calculator.core.operations.api.Operation;
import com.pajor.calculator.core.operations.impl.Addition;
import com.pajor.calculator.core.operations.impl.Division;
import com.pajor.calculator.core.operations.impl.Multiplication;
import com.pajor.calculator.core.operations.impl.Power;
import com.pajor.calculator.core.operations.impl.Sqrt;
import com.pajor.calculator.core.operations.impl.Subtraction;

import java.util.HashMap;
import java.util.Map;

public class CalculatorServiceImpl implements CalculatorService {
    
    private final Map<String, Operation> operations = new HashMap<>();
    private final SimpleCalculationEngine engine = new SimpleCalculationEngine();

    public CalculatorServiceImpl() {
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("÷", new Division());
        operations.put("/", new Division());
        operations.put("^", new Power());
        operations.put("**", new Power());
        operations.put("power", new Power());
        operations.put("√", new Sqrt());
        operations.put("sqrt", new Sqrt());
    }

    @Override
    public double performCalculation(String[] tokens) {
        // ConvertToRPN

        // Evaluate Postfix Expression
        
        Operation op = operations.get(operator);
        if (op != null) {
            return engine.calculate(op, a, b);
        }
        throw new UnsupportedOperationException("Operation not unsupported: " + operator);
    }

    @Override
    public boolean validateOperator(String operator) {
        if (operations.containsKey(operator)) {
            return true;
        }
        return false;
    }

    
}