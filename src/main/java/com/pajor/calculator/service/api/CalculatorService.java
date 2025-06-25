package com.pajor.calculator.service.api;

import java.util.List;

public interface CalculatorService {
    double performCalculation(String expr);
    List<String> tokenize(String expr);
    List<String> toRPN(List<String> tokens);
    double evaluateRPN(List<String> rpn);
    boolean validateOperator(String operator);
    public void addToHistory(String equation, double result);
    public String getFromHistory(int direction);
}