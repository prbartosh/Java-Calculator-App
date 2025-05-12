package com.pajor.calculator.service.api;

public interface CalculatorService {
    double performCalculation(String operator, double a, double b);
    boolean validateOperator(String operator);
}