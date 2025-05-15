package com.pajor.calculator.ui.console;

import com.pajor.calculator.service.api.CalculatorService;

public class ConsoleInputHandler {
    private final CalculatorService calculatorService;

    public ConsoleInputHandler(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public String passToService(String input) throws Exception {
        try {
            return String.valueOf(calculatorService.performCalculation(input));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}