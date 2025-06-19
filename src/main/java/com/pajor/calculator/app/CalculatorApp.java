package com.pajor.calculator.app;

import java.util.Scanner;

import javax.swing.SwingUtilities;

import com.pajor.calculator.service.impl.CalculatorServiceImpl;
import com.pajor.calculator.ui.console.ConsoleUI;
import com.pajor.calculator.ui.gui.GUIUI;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        // ConsoleUI consoleUI = new ConsoleUI(calculatorService);
        SwingUtilities.invokeLater(() -> {
            GUIUI guiUI = new GUIUI(calculatorService);
        });
        // String input = "2.2 + 2";
        // var tokens = calculatorService.tokenize(input);
        // var rpn = calculatorService.toRPN(tokens);
        // System.out.println(rpn);

        // consoleUI.start();
    }


}

