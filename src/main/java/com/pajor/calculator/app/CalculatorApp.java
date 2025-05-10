package com.pajor.calculator.app;

import com.pajor.calculator.service.impl.CalculatorServiceImpl;
import com.pajor.calculator.ui.console.ConsoleUI;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        ConsoleUI consoleUI = new ConsoleUI(calculatorService);

        consoleUI.start();
    }
}

