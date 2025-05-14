package com.pajor.calculator.ui.console;

import com.pajor.calculator.service.api.CalculatorService;

public class ConsoleInputHandler {
    private double a;
    private double b;
    private final CalculatorService calculatorService;

    public ConsoleInputHandler(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public String[] parseInput(String input) {
        // Expecting input format: "number operator number"
        String[] parts = input.strip().split(" ");
        return parts;
    }

    public String passToService(String[] tokens) throws Exception {
        try {
            return String.valueOf(calculatorService.performCalculation(tokens));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}