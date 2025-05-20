package com.pajor.calculator.core.operations.api;

public interface Operation {
    int arity();
    double apply(double... args);
}

