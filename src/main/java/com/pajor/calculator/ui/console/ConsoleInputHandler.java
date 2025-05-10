package com.pajor.calculator.ui.console;


import com.pajor.calculator.service.api.CalculatorService;


class ConsoleInputHandler {
    private double a;
    private double b;
    private final CalculatorService calculatorService;
    private String[] parts;

    public ConsoleInputHandler(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void parseInput(String input) {
        this.parts = input.strip().split(" ");
        this.a = Double.parseDouble(parts[0]);
        this.b = Double.parseDouble(parts[2]);
    }

    public String passToService() {
        try {
            return String.valueOf(calculatorService.performCalculation(parts[1], a, b));
        } catch (Exception e) {
            return e.getMessage();
        }
    }






}