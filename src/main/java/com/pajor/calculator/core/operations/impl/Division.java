package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;
import com.pajor.calculator.exception.DivisionByZeroException;

public class Division implements Operation {
    public int arity() { return 2; }
    @Override
    public double apply(double... args) {
        if (args[1] == 0){
            throw new DivisionByZeroException("Division by Zero is not allowed!");
        } else{
            return args[0] / args[1];
        }
    }
}

