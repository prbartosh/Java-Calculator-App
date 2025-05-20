package com.pajor.calculator.core.operations.impl;

import com.pajor.calculator.core.operations.api.Operation;

public class Multiplication implements Operation{
    public int arity() { return 2; }
    @Override
    public double apply(double... args){
        return args[0] * args[1];
    }
}