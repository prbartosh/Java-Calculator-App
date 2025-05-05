package com.pajor.calculator.ui.console;

import java.util.Scanner;

import com.pajor.calculator.service.api.CalculatorService;
import com.pajor.calculator.ui.api.UserInterface;

public class ConsoleUI implements UserInterface {
    private final CalculatorService calculatorService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public void start() {
        System.out.println("Welcome in Calculator!");

        while (true) {
            System.out.println("Select you operand eg.(+,-,/,*,**,√): ");
            String operand = getUserInput();
            System.out.println("Provide a: ");
            double a = Double.parseDouble(getUserInput());
            System.out.println("Provide b: ");
            double b = Double.parseDouble(getUserInput());

            showResult(String.valueOf(calculatorService.performCalculation(operand, a, b)));
        }

    }

    @Override
    public void showResult(String result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void showError(String message) {
        // TODO Auto-generated method stub
        
    }
}