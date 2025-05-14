package com.pajor.calculator.service.api;

import java.util.Stack;

public interface CalculatorService {
    double performCalculation(String[] tokens);
    Stack<Double> shuntingYard(String[] tokens);
    double evaluateRPN(Stack<Double> postfix);
    boolean validateOperator(String operator);
}