package com.pajor.calculator.ui.console;

import com.pajor.calculator.service.api.CalculatorService;

public class ConsoleInputHandler {
    private double a;
    private double b;
    private final CalculatorService calculatorService;
    private String[] parts;

    public ConsoleInputHandler(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void parseInput(String input) {
        // Expecting input format: "number operator number"
        parts = input.strip().split(" ");
        if(parts.length != 3) {
            throw new IllegalArgumentException("Input must be in format: [number] [operator] [number]");
        }
        try {
            a = Double.parseDouble(parts[0]);
            b = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numeric format in input.", e);
        }
    }

    public String passToService() throws Exception {
        if (calculatorService.validateOperator(parts[1])) {
            return String.valueOf(calculatorService.performCalculation(parts[1], a, b));
        } else {
            throw new IllegalArgumentException("Invalid operator: " + parts[1]);
        }
    }
}