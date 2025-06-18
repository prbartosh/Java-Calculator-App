package com.pajor.calculator.ui.gui;

import com.pajor.calculator.service.api.CalculatorService;

public class GUIInputHandler {
    private final CalculatorService calculatorService;

    public GUIInputHandler(CalculatorService calcServ) {
        this.calculatorService = calcServ;
    }

    public String passToService(String input) throws Exception {
        try {
            return String.valueOf(calculatorService.performCalculation(input));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
