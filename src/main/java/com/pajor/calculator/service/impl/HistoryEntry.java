package com.pajor.calculator.service.impl;

public class HistoryEntry {
    private final String equation;
    private final double result;

    public HistoryEntry(String equation, double result) {
        this.equation = equation;
        this.result = result;
    }

    public String getEquation() { return equation; }
    public double getResult() { return result; }
}
