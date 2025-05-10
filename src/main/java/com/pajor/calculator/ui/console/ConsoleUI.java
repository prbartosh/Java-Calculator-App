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

            
            // pass input to inputHandler
                // handle input in inputHandler
            consoleInputHandler.parseInput(input);
                    // check for correctness
                    // split for parts
                    // pass equasion to service -> performCalculation(operation, a, b)
            String result = consoleInputHandler.passToService();
                    // get result
                // pass result to OutputHandler
                    // handle output
                        // if ok -> showResult(result)
                        // if error -> showError(message)'
            System.out.println(result);

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