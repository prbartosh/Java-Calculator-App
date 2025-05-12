package com.pajor.calculator.ui.console;

import java.util.Scanner;

import com.pajor.calculator.service.api.CalculatorService;
import com.pajor.calculator.ui.api.UserInterface;

public class ConsoleUI implements UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    private final CalculatorService calculatorService;
    private final ConsoleInputHandler consoleInputHandler;
    private String input;

    public ConsoleUI(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        this.consoleInputHandler = new ConsoleInputHandler(calculatorService);
    }

    @Override
    public void start() {
        System.out.println("Welcome in Calculator!");


        while (true) {
            System.out.println("Provide equastion: ");
            input = getUserInput();
            
            if (input == "exit"){
                System.out.println("Goodbye!");
                break;
            }

            try {
                consoleInputHandler.parseInput(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            try {
                String result = consoleInputHandler.passToService();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void showResult(String result) {
        System.out.println("Result: " + result);
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }

    @Override
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}